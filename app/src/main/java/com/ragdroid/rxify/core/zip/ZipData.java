package com.ragdroid.rxify.core.zip;

/**
 * Created by garimajain on 09/11/16.
 */

public final class ZipData {

    long fluxWeedTime;
    long crabHairTime;

    public ZipData() {
        reset();
    }

    public void reset() {
        fluxWeedTime = 0L;
        crabHairTime = 0L;
    }

    public void setFluxWeedTime(long fluxWeedTime) {
        this.fluxWeedTime = fluxWeedTime;
    }

    public void setCrabHairTime(long crabHairTime) {
        this.crabHairTime = crabHairTime;
    }


    public boolean isCrabHairFirst() {
        return crabHairTime != 0L && (fluxWeedTime == 0L || crabHairTime < fluxWeedTime);
    }

    public boolean isFluxWeedFirst() {
        return fluxWeedTime != 0L && (crabHairTime == 0L || fluxWeedTime < crabHairTime);
    }

    public boolean isBothArrived() {
        return fluxWeedTime != 0L && crabHairTime != 0L;
    }

}
