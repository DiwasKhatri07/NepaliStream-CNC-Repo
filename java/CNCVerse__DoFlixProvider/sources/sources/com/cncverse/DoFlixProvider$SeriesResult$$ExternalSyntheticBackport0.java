package com.cncverse;

import com.android.tools.r8.annotations.SynthesizedClassV2;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/DoFlixProvider/classes.dex */
@SynthesizedClassV2(apiLevel = -2, kind = 31, versionHash = "b849e8a9f6cceff267251a73644faacc801ad726cc8f22a9c323c56a203f5446")
public final /* synthetic */ class DoFlixProvider$SeriesResult$$ExternalSyntheticBackport0 {
    /* JADX INFO: renamed from: m */
    public static /* synthetic */ int m0m(double d) {
        long jDoubleToLongBits = Double.doubleToLongBits(d);
        return (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
    }
}
