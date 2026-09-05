package com.phisher98;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/phisher98/MappleInitReq;", "", "mediaId", "", "mediaType", "", "requestToken", "pow", "Lcom/phisher98/MapplePowSolve;", "<init>", "(ILjava/lang/String;Ljava/lang/String;Lcom/phisher98/MapplePowSolve;)V", "getMediaId", "()I", "getMediaType", "()Ljava/lang/String;", "getRequestToken", "getPow", "()Lcom/phisher98/MapplePowSolve;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class MappleInitReq {
    private final int mediaId;

    @NotNull
    private final String mediaType;

    @Nullable
    private final MapplePowSolve pow;

    @NotNull
    private final String requestToken;

    public static /* synthetic */ MappleInitReq copy$default(MappleInitReq mappleInitReq, int i, String str, String str2, MapplePowSolve mapplePowSolve, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = mappleInitReq.mediaId;
        }
        if ((i2 & 2) != 0) {
            str = mappleInitReq.mediaType;
        }
        if ((i2 & 4) != 0) {
            str2 = mappleInitReq.requestToken;
        }
        if ((i2 & 8) != 0) {
            mapplePowSolve = mappleInitReq.pow;
        }
        return mappleInitReq.copy(i, str, str2, mapplePowSolve);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getMediaId() {
        return this.mediaId;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMediaType() {
        return this.mediaType;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getRequestToken() {
        return this.requestToken;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final MapplePowSolve getPow() {
        return this.pow;
    }

    @NotNull
    public final MappleInitReq copy(int mediaId, @NotNull String mediaType, @NotNull String requestToken, @Nullable MapplePowSolve pow) {
        return new MappleInitReq(mediaId, mediaType, requestToken, pow);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MappleInitReq)) {
            return false;
        }
        MappleInitReq mappleInitReq = (MappleInitReq) other;
        return this.mediaId == mappleInitReq.mediaId && Intrinsics.areEqual(this.mediaType, mappleInitReq.mediaType) && Intrinsics.areEqual(this.requestToken, mappleInitReq.requestToken) && Intrinsics.areEqual(this.pow, mappleInitReq.pow);
    }

    public int hashCode() {
        return (((((this.mediaId * 31) + this.mediaType.hashCode()) * 31) + this.requestToken.hashCode()) * 31) + (this.pow == null ? 0 : this.pow.hashCode());
    }

    @NotNull
    public String toString() {
        return "MappleInitReq(mediaId=" + this.mediaId + ", mediaType=" + this.mediaType + ", requestToken=" + this.requestToken + ", pow=" + this.pow + ')';
    }

    public MappleInitReq(int mediaId, @NotNull String mediaType, @NotNull String requestToken, @Nullable MapplePowSolve pow) {
        this.mediaId = mediaId;
        this.mediaType = mediaType;
        this.requestToken = requestToken;
        this.pow = pow;
    }

    public /* synthetic */ MappleInitReq(int i, String str, String str2, MapplePowSolve mapplePowSolve, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, str2, (i2 & 8) != 0 ? null : mapplePowSolve);
    }

    public final int getMediaId() {
        return this.mediaId;
    }

    @NotNull
    public final String getMediaType() {
        return this.mediaType;
    }

    @NotNull
    public final String getRequestToken() {
        return this.requestToken;
    }

    @Nullable
    public final MapplePowSolve getPow() {
        return this.pow;
    }
}
