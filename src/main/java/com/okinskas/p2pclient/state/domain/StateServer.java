package com.okinskas.p2pclient.state.domain;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class StateServer implements Runnable {

    private static String GET = "get";
    private static String INCREMENT = "inc";
    private static String DECREMENT = "dec";
    private static String UPDATE = "upd";

    private State state;
    private DatagramSocket socket;
    private boolean running;
    private byte[] buf = new byte[256];

    public StateServer(State state, DatagramSocket socket) {
        this.state = state;
        this.socket = socket;
    }

    @Override
    public void run() {
        running = true;

        while (running) {
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            try {
                socket.receive(packet);

                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                packet = new DatagramPacket(buf, buf.length, address, port);
                String received = new String(packet.getData(), 0, packet.getLength());

                if (received.equals(INCREMENT)) {
                    state.incrementTrackedInteger();
                } else if (received.equals(DECREMENT)) {
                    state.decrementTrackedInteger();
                }

                // Serialise State Object and send as packet to client.

                // Currently resending original packet.
                socket.send(packet);
            } catch (IOException e) {
                // socket.receive(~) blocks execution until it receives.
                // To stop the thread forcefully, we close the socket.
                System.out.println("Socket closed.");
            }
        }
        socket.close();
    }

    public void end() {
        running = false;
    }
}
