package jerseydemo;

import domein.KoffieSoort;

import javax.ws.rs.*;
import java.util.List;

@Path("koffie")
public class KoffieResource {
    @GET
    @Produces("application/json")
    public List<KoffieSoort> getAlleKoffie(){
//        throw new RuntimeException("Dummyfout");

        return StartupListener.alleKoffie;
    }

    @GET
    @Produces("application/json")
    @Path("{code}")
    public KoffieSoort getKoffie(@PathParam("code") String barcode){
        for(KoffieSoort kf: StartupListener.alleKoffie){
            if(kf.getBarcode().equals(barcode)){
                return kf;
            }
        }
        return null;
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public void voegSoortToe(KoffieSoort kf){
        StartupListener.alleKoffie.add(kf);
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    @Path("{code}")
    public KoffieSoort updateKoffie(@PathParam("code") String barcode, KoffieSoort gestuurdeKoffie){
        for(KoffieSoort kf: StartupListener.alleKoffie){
            if(kf.getBarcode().equals(barcode)){
                kf.setNaam(gestuurdeKoffie.getNaam());
                kf.setPrijs(gestuurdeKoffie.getPrijs());
                kf.setSterkte(gestuurdeKoffie.getSterkte());
            }
        }
        return null;
    }


    @DELETE
    @Path("{code}")
    public void verwijderKoffie(@PathParam("code") String barcode){
        for(KoffieSoort kf: StartupListener.alleKoffie){
            if(kf.getBarcode().equals(barcode)){
                StartupListener.alleKoffie.remove(kf);
            }
        }
    }
}
