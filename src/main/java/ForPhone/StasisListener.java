package ForPhone;

import ForPlants.CandyController;
import ForPlants.CandyModel;
import ForPlants.ForStaticVar;
import ch.loway.oss.ari4java.ARI;
import ch.loway.oss.ari4java.generated.AriWSHelper;
import ch.loway.oss.ari4java.generated.models.*;
import ch.loway.oss.ari4java.tools.AriConnectionEvent;
import ch.loway.oss.ari4java.tools.RestException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;




public class StasisListener extends AriWSHelper {

    private final ARI ari;
    private String id;
    private boolean isEnded = false;
    Random rando = new Random();


    public static void getSeven(){
        CandyController.example = 7;
    }


    public StasisListener(ARI ari) {
        this.ari = ari;
    }



    @Override
    public void onSuccess(Message message) {
        super.onSuccess(message);
    }

    @Override
    public void onFailure(RestException e) {
        super.onFailure(e);
    }


    @Override
    public void onConnectionEvent(AriConnectionEvent event) {
        super.onConnectionEvent(event);
    }

    @Override
    protected void onChannelEnteredBridge(ChannelEnteredBridge message) {
        super.onChannelEnteredBridge(message);
    }

    @Override
    protected void onPlaybackContinuing(PlaybackContinuing message) { super.onPlaybackContinuing(message); }

    @Override
    protected void onPeerStatusChange(PeerStatusChange message) {
        super.onPeerStatusChange(message);
    }

    @Override
    protected void onChannelLeftBridge(ChannelLeftBridge message) {
        super.onChannelLeftBridge(message);
    }

    @Override
    protected void onChannelVarset(ChannelVarset message) {
        super.onChannelVarset(message);
    }

    @Override
    protected void onTextMessageReceived(TextMessageReceived message) {
        super.onTextMessageReceived(message);
    }

    @Override
    protected void onChannelConnectedLine(ChannelConnectedLine message) {
        super.onChannelConnectedLine(message);
    }

    @Override
    protected void onChannelUnhold(ChannelUnhold message) {
        super.onChannelUnhold(message);
    }

    @Override
    protected void onEndpointStateChange(EndpointStateChange message) {
        super.onEndpointStateChange(message);
    }

    @Override
    protected void onPlaybackStarted(PlaybackStarted message) {
        System.out.println("Start!");
        super.onPlaybackStarted(message);
    }

    @Override
    protected void onStasisEnd(StasisEnd message) {
        super.onStasisEnd(message);
    }

    @Override
    protected void onChannelDialplan(ChannelDialplan message) {
        super.onChannelDialplan(message);
    }

    @Override
    protected void onChannelDtmfReceived(ChannelDtmfReceived message) {
        super.onChannelDtmfReceived(message);
    }

    @Override
    protected void onDeviceStateChanged(DeviceStateChanged message) {
        super.onDeviceStateChanged(message);
    }

    @Override
    protected void onApplicationReplaced(ApplicationReplaced message) {
        super.onApplicationReplaced(message);
    }

    @Override
    protected void onContactInfo(ContactInfo message) {
        super.onContactInfo(message);
    }

    @Override
    protected void onRecordingFailed(RecordingFailed message) {
        super.onRecordingFailed(message);
    }

    @Override
    protected void onChannelStateChange(ChannelStateChange message) {
        super.onChannelStateChange(message);
    }

    @Override
    protected void onBridgeBlindTransfer(BridgeBlindTransfer message) {
        super.onBridgeBlindTransfer(message);
    }

    @Override
    protected void onBridgeDestroyed(BridgeDestroyed message) {
        super.onBridgeDestroyed(message);
    }

    @Override
    protected void onBridgeMerged(BridgeMerged message) {
        super.onBridgeMerged(message);
    }

    @Override
    protected void onRecordingStarted(RecordingStarted message) {
        super.onRecordingStarted(message);
    }

    @Override
    protected void onPeer(Peer message) {
        super.onPeer(message);
    }

    @Override
    protected void onApplicationMoveFailed(ApplicationMoveFailed message) {
        super.onApplicationMoveFailed(message);
    }

    @Override
    protected void onMissingParams(MissingParams message) {
        super.onMissingParams(message);
    }

    @Override
    protected void onChannelCreated(ChannelCreated message) {
        super.onChannelCreated(message);
    }

    @Override
    protected void onRecordingFinished(RecordingFinished message) {
        super.onRecordingFinished(message);
    }

    @Override
    protected void onChannelHangupRequest(ChannelHangupRequest message) {
        System.out.println("Now stooop. Nope");
        isEnded = true;
        super.onChannelHangupRequest(message);

    }

    @Override
    protected void onStasisStart(StasisStart message) {
        id = message.getChannel().getId();
        isEnded = false;

        try{

            List<Sound> list = ari.sounds().list().execute();
            List<Sound> list2 = new ArrayList<>();


//            for(int i = 0; i<list.size(); i++){
//                if(list.get(i).getId().startsWith("Sound")){
//                    list2.add(list.get(i));
//                }
//            }
//            int n = rando.nextInt(list2.size());
//            if(list2.size() != 0){
//                for(int i = 0; i<list2.size(); i++){
//                    System.out.println(list2.get(i).getId());
//                }
//            }else{
//                System.out.println("No music!");
//            }



//                        for(int i = 0; i<list.size(); i++) {
//                            System.out.println(list.get(i).getId());
//                        }




//            ari.channels().answer(id).execute();
//            ari.channels().play(id, ("sound:" + list2.get(n).getId())).execute();
//            ari.channels().play(id, ("sound:" + "followme/sorry")).execute();
            ari.channels().play(id, ("sound:" + "basic-pbx-ivr-main")).execute();
//            System.out.println("Now is playing " + list2.get(n).getId());
//            ForStaticVar.pluscount();

        }catch (RestException e) {
            e.printStackTrace();
        }


        super.onStasisStart(message);
    }


    @Override
    protected void onDial(Dial message) {
        super.onDial(message);
    }

    @Override
    protected void onChannelTalkingFinished(ChannelTalkingFinished message) {
        super.onChannelTalkingFinished(message);
    }

    @Override
    protected void onContactStatusChange(ContactStatusChange message) {
        super.onContactStatusChange(message);
    }

    @Override
    protected void onChannelTalkingStarted(ChannelTalkingStarted message) {
        super.onChannelTalkingStarted(message);
    }

    @Override
    protected void onPlaybackFinished(PlaybackFinished message) {
//        String justName = "Name is - ";
//        if(isEnded==false){
//            System.out.println("Person didn't hang up");
//        }else{
//            System.out.println("Person hanged up");
//        }
        super.onPlaybackFinished(message);

    }

    @Override
    protected void onBridgeCreated(BridgeCreated message) {
        super.onBridgeCreated(message);
    }

    @Override
    protected void onChannelDestroyed(ChannelDestroyed message) {
        super.onChannelDestroyed(message);
    }

    @Override
    protected void onChannelHold(ChannelHold message) {
        super.onChannelHold(message);
    }

    @Override
    protected void onChannelUserevent(ChannelUserevent message) {
        super.onChannelUserevent(message);
    }

    @Override
    protected void onBridgeVideoSourceChanged(BridgeVideoSourceChanged message) {
        super.onBridgeVideoSourceChanged(message);
    }

    @Override
    protected void onBridgeAttendedTransfer(BridgeAttendedTransfer message) {
        super.onBridgeAttendedTransfer(message);
    }

    @Override
    protected void onChannelCallerId(ChannelCallerId message) {
        super.onChannelCallerId(message);
    }

}
