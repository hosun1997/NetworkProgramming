package TCP;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class InetAddressEx {

    public static void main(String[] args) {

        try {
            InetAddress inetAddress = InetAddress.getLocalHost();                           //getLocalHost()
            System.out.println("LocalHost 주소: " + inetAddress);
            System.out.println("Loopback 주소: " + InetAddress.getLoopbackAddress());                           //getLoopbackAddress()
            System.out.println("네이버의 IP주소: " + InetAddress.getByName("www.naver.com"));                //getByName(String host);
            byte[] address = InetAddress.getByName("www.naver.com").getAddress();      //
            System.out.println(Arrays.toString(address));

            for(int i = 0; i < address.length; i++) {
                if(address[i] < 0) {
                    System.out.println(address[i] + 256);
                } else {
                    System.out.println(address[i]);
                }
            }


            System.out.println(InetAddress.getByName("www.google.com").isReachable(100)); //Reachable
            System.out.println(InetAddress.getByName("www.naver.com").isReachable(500)); // false 이유 : 보안상 icmp 패킷을 받지 않음
            System.out.println(InetAddress.getByName("www.11st.com").isReachable(500));
            System.out.println(InetAddress.getByName("127.0.0.1").isReachable(500)); // -> 서버 소켓 만들 때 // Transport까지 설정(보안, 헤더 등) -> 그 이하는 우리가 설정 X


        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
