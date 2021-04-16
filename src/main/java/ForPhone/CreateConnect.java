package ForPhone;

import ch.loway.oss.ari4java.ARI;
import ch.loway.oss.ari4java.AriVersion;

public class CreateConnect {

    public static void main(String[] args) {

        ARI ari = null;

        try{
            ari = ARI.build("http://192.168.55.169:8088/",
                    "candy",
                    "unifun", "unifun",
                    AriVersion.ARI_4_0_0);
            StasisListener stasis = new StasisListener(ari);
            ari.eventsCallback(stasis);
            System.out.println("Norm");

        }catch (Throwable t) {
            t.printStackTrace();
        }


    }

}
