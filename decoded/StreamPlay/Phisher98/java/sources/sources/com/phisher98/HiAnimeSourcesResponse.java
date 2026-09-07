package com.phisher98;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0015JP\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0014\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\"\u001a\u00020#HÖ\u0081\u0004J\n\u0010$\u001a\u00020\u0005HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0015¨\u0006%"}, d2 = {"Lcom/phisher98/HiAnimeSourcesResponse;", "", "sources", "Lcom/phisher98/HiAnimeSources;", "enc", "", "tracks", "", "Lcom/phisher98/HiAnimeTrack;", "t", "", "server", "<init>", "(Lcom/phisher98/HiAnimeSources;Ljava/lang/String;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Long;)V", "getSources", "()Lcom/phisher98/HiAnimeSources;", "getEnc", "()Ljava/lang/String;", "getTracks", "()Ljava/util/List;", "getT", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getServer", "component1", "component2", "component3", "component4", "component5", "copy", "(Lcom/phisher98/HiAnimeSources;Ljava/lang/String;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Long;)Lcom/phisher98/HiAnimeSourcesResponse;", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class HiAnimeSourcesResponse {

    @Nullable
    private final String enc;

    @Nullable
    private final Long server;

    @Nullable
    private final HiAnimeSources sources;

    @Nullable
    private final Long t;

    @Nullable
    private final List<HiAnimeTrack> tracks;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HiAnimeSourcesResponse copy$default(HiAnimeSourcesResponse hiAnimeSourcesResponse, HiAnimeSources hiAnimeSources, String str, List list, Long l, Long l2, int i, Object obj) {
        if ((i & 1) != 0) {
            hiAnimeSources = hiAnimeSourcesResponse.sources;
        }
        if ((i & 2) != 0) {
            str = hiAnimeSourcesResponse.enc;
        }
        if ((i & 4) != 0) {
            list = hiAnimeSourcesResponse.tracks;
        }
        if ((i & 8) != 0) {
            l = hiAnimeSourcesResponse.t;
        }
        if ((i & 16) != 0) {
            l2 = hiAnimeSourcesResponse.server;
        }
        Long l3 = l2;
        List list2 = list;
        return hiAnimeSourcesResponse.copy(hiAnimeSources, str, list2, l, l3);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final HiAnimeSources getSources() {
        return this.sources;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getEnc() {
        return this.enc;
    }

    @Nullable
    public final List<HiAnimeTrack> component3() {
        return this.tracks;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Long getT() {
        return this.t;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Long getServer() {
        return this.server;
    }

    @NotNull
    public final HiAnimeSourcesResponse copy(@Nullable HiAnimeSources sources, @Nullable String enc, @Nullable List<HiAnimeTrack> tracks, @Nullable Long t, @Nullable Long server) {
        return new HiAnimeSourcesResponse(sources, enc, tracks, t, server);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HiAnimeSourcesResponse)) {
            return false;
        }
        HiAnimeSourcesResponse hiAnimeSourcesResponse = (HiAnimeSourcesResponse) other;
        return Intrinsics.areEqual(this.sources, hiAnimeSourcesResponse.sources) && Intrinsics.areEqual(this.enc, hiAnimeSourcesResponse.enc) && Intrinsics.areEqual(this.tracks, hiAnimeSourcesResponse.tracks) && Intrinsics.areEqual(this.t, hiAnimeSourcesResponse.t) && Intrinsics.areEqual(this.server, hiAnimeSourcesResponse.server);
    }

    public int hashCode() {
        return ((((((((this.sources == null ? 0 : this.sources.hashCode()) * 31) + (this.enc == null ? 0 : this.enc.hashCode())) * 31) + (this.tracks == null ? 0 : this.tracks.hashCode())) * 31) + (this.t == null ? 0 : this.t.hashCode())) * 31) + (this.server != null ? this.server.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "HiAnimeSourcesResponse(sources=" + this.sources + ", enc=" + this.enc + ", tracks=" + this.tracks + ", t=" + this.t + ", server=" + this.server + ')';
    }

    public HiAnimeSourcesResponse(@Nullable HiAnimeSources sources, @Nullable String enc, @Nullable List<HiAnimeTrack> list, @Nullable Long t, @Nullable Long server) {
        this.sources = sources;
        this.enc = enc;
        this.tracks = list;
        this.t = t;
        this.server = server;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ HiAnimeSourcesResponse(HiAnimeSources hiAnimeSources, String str, List list, Long l, Long l2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        String str2;
        if ((i & 2) == 0) {
            str2 = str;
        } else {
            str2 = null;
        }
        this(hiAnimeSources, str2, list, l, l2);
    }

    @Nullable
    public final HiAnimeSources getSources() {
        return this.sources;
    }

    @Nullable
    public final String getEnc() {
        return this.enc;
    }

    @Nullable
    public final List<HiAnimeTrack> getTracks() {
        return this.tracks;
    }

    @Nullable
    public final Long getT() {
        return this.t;
    }

    @Nullable
    public final Long getServer() {
        return this.server;
    }
}
