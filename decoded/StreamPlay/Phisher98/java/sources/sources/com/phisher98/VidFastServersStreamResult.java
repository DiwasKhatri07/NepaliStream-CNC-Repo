package com.phisher98;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0010J8\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/phisher98/VidFastServersStreamResult;", "", "url", "", "tracks", "", "Lcom/phisher98/VidFastServersTrack;", "noReferrer", "", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;)V", "getUrl", "()Ljava/lang/String;", "getTracks", "()Ljava/util/List;", "getNoReferrer", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;)Lcom/phisher98/VidFastServersStreamResult;", "equals", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class VidFastServersStreamResult {

    @Nullable
    private final Boolean noReferrer;

    @Nullable
    private final List<VidFastServersTrack> tracks;

    @Nullable
    private final String url;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VidFastServersStreamResult copy$default(VidFastServersStreamResult vidFastServersStreamResult, String str, List list, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = vidFastServersStreamResult.url;
        }
        if ((i & 2) != 0) {
            list = vidFastServersStreamResult.tracks;
        }
        if ((i & 4) != 0) {
            bool = vidFastServersStreamResult.noReferrer;
        }
        return vidFastServersStreamResult.copy(str, list, bool);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    public final List<VidFastServersTrack> component2() {
        return this.tracks;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Boolean getNoReferrer() {
        return this.noReferrer;
    }

    @NotNull
    public final VidFastServersStreamResult copy(@Nullable String url, @Nullable List<VidFastServersTrack> tracks, @Nullable Boolean noReferrer) {
        return new VidFastServersStreamResult(url, tracks, noReferrer);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VidFastServersStreamResult)) {
            return false;
        }
        VidFastServersStreamResult vidFastServersStreamResult = (VidFastServersStreamResult) other;
        return Intrinsics.areEqual(this.url, vidFastServersStreamResult.url) && Intrinsics.areEqual(this.tracks, vidFastServersStreamResult.tracks) && Intrinsics.areEqual(this.noReferrer, vidFastServersStreamResult.noReferrer);
    }

    public int hashCode() {
        return ((((this.url == null ? 0 : this.url.hashCode()) * 31) + (this.tracks == null ? 0 : this.tracks.hashCode())) * 31) + (this.noReferrer != null ? this.noReferrer.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "VidFastServersStreamResult(url=" + this.url + ", tracks=" + this.tracks + ", noReferrer=" + this.noReferrer + ')';
    }

    public VidFastServersStreamResult(@Nullable String url, @Nullable List<VidFastServersTrack> list, @Nullable Boolean noReferrer) {
        this.url = url;
        this.tracks = list;
        this.noReferrer = noReferrer;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    public final List<VidFastServersTrack> getTracks() {
        return this.tracks;
    }

    @Nullable
    public final Boolean getNoReferrer() {
        return this.noReferrer;
    }
}
