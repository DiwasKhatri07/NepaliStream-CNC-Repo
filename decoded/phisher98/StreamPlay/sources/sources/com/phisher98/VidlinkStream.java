package com.phisher98;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J?\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0001J\u0014\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u001cHÖ\u0081\u0004J\n\u0010\u001d\u001a\u00020\u0003HÖ\u0081\u0004R'\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR3\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004\u0092\u0002\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R-\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006X\u0087\u0004\u0092\u0002\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/phisher98/VidlinkStream;", "", "playlist", "", "qualities", "", "Lcom/phisher98/VidlinkQuality;", "captions", "", "Lcom/phisher98/VidlinkCaption;", "<init>", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/List;)V", "getPlaylist", "()Ljava/lang/String;", "Lcom/google/gson/annotations/SerializedName;", "value", "getQualities", "()Ljava/util/Map;", "getCaptions", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class VidlinkStream {

    @SerializedName("captions")
    @Nullable
    private final List<VidlinkCaption> captions;

    @SerializedName("playlist")
    @Nullable
    private final String playlist;

    @SerializedName("qualities")
    @Nullable
    private final Map<String, VidlinkQuality> qualities;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VidlinkStream copy$default(VidlinkStream vidlinkStream, String str, Map map, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = vidlinkStream.playlist;
        }
        if ((i & 2) != 0) {
            map = vidlinkStream.qualities;
        }
        if ((i & 4) != 0) {
            list = vidlinkStream.captions;
        }
        return vidlinkStream.copy(str, map, list);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPlaylist() {
        return this.playlist;
    }

    @Nullable
    public final Map<String, VidlinkQuality> component2() {
        return this.qualities;
    }

    @Nullable
    public final List<VidlinkCaption> component3() {
        return this.captions;
    }

    @NotNull
    public final VidlinkStream copy(@Nullable String playlist, @Nullable Map<String, VidlinkQuality> qualities, @Nullable List<VidlinkCaption> captions) {
        return new VidlinkStream(playlist, qualities, captions);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VidlinkStream)) {
            return false;
        }
        VidlinkStream vidlinkStream = (VidlinkStream) other;
        return Intrinsics.areEqual(this.playlist, vidlinkStream.playlist) && Intrinsics.areEqual(this.qualities, vidlinkStream.qualities) && Intrinsics.areEqual(this.captions, vidlinkStream.captions);
    }

    public int hashCode() {
        return ((((this.playlist == null ? 0 : this.playlist.hashCode()) * 31) + (this.qualities == null ? 0 : this.qualities.hashCode())) * 31) + (this.captions != null ? this.captions.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "VidlinkStream(playlist=" + this.playlist + ", qualities=" + this.qualities + ", captions=" + this.captions + ')';
    }

    public VidlinkStream(@Nullable String playlist, @Nullable Map<String, VidlinkQuality> map, @Nullable List<VidlinkCaption> list) {
        this.playlist = playlist;
        this.qualities = map;
        this.captions = list;
    }

    @Nullable
    public final String getPlaylist() {
        return this.playlist;
    }

    @Nullable
    public final Map<String, VidlinkQuality> getQualities() {
        return this.qualities;
    }

    @Nullable
    public final List<VidlinkCaption> getCaptions() {
        return this.captions;
    }
}
