package com.phisher98;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003J>\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0014\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u001cHÖ\u0081\u0004J\n\u0010\u001d\u001a\u00020\bHÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/phisher98/MappleInitRes;", "", "success", "", "requiresPow", "pow", "Lcom/phisher98/MapplePowInfo;", "token", "", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/phisher98/MapplePowInfo;Ljava/lang/String;)V", "getSuccess", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getRequiresPow", "getPow", "()Lcom/phisher98/MapplePowInfo;", "getToken", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/phisher98/MapplePowInfo;Ljava/lang/String;)Lcom/phisher98/MappleInitRes;", "equals", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class MappleInitRes {

    @Nullable
    private final MapplePowInfo pow;

    @Nullable
    private final Boolean requiresPow;

    @Nullable
    private final Boolean success;

    @Nullable
    private final String token;

    public MappleInitRes() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ MappleInitRes copy$default(MappleInitRes mappleInitRes, Boolean bool, Boolean bool2, MapplePowInfo mapplePowInfo, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = mappleInitRes.success;
        }
        if ((i & 2) != 0) {
            bool2 = mappleInitRes.requiresPow;
        }
        if ((i & 4) != 0) {
            mapplePowInfo = mappleInitRes.pow;
        }
        if ((i & 8) != 0) {
            str = mappleInitRes.token;
        }
        return mappleInitRes.copy(bool, bool2, mapplePowInfo, str);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Boolean getSuccess() {
        return this.success;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Boolean getRequiresPow() {
        return this.requiresPow;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MapplePowInfo getPow() {
        return this.pow;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    @NotNull
    public final MappleInitRes copy(@Nullable Boolean success, @Nullable Boolean requiresPow, @Nullable MapplePowInfo pow, @Nullable String token) {
        return new MappleInitRes(success, requiresPow, pow, token);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MappleInitRes)) {
            return false;
        }
        MappleInitRes mappleInitRes = (MappleInitRes) other;
        return Intrinsics.areEqual(this.success, mappleInitRes.success) && Intrinsics.areEqual(this.requiresPow, mappleInitRes.requiresPow) && Intrinsics.areEqual(this.pow, mappleInitRes.pow) && Intrinsics.areEqual(this.token, mappleInitRes.token);
    }

    public int hashCode() {
        return ((((((this.success == null ? 0 : this.success.hashCode()) * 31) + (this.requiresPow == null ? 0 : this.requiresPow.hashCode())) * 31) + (this.pow == null ? 0 : this.pow.hashCode())) * 31) + (this.token != null ? this.token.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "MappleInitRes(success=" + this.success + ", requiresPow=" + this.requiresPow + ", pow=" + this.pow + ", token=" + this.token + ')';
    }

    public MappleInitRes(@Nullable Boolean success, @Nullable Boolean requiresPow, @Nullable MapplePowInfo pow, @Nullable String token) {
        this.success = success;
        this.requiresPow = requiresPow;
        this.pow = pow;
        this.token = token;
    }

    public /* synthetic */ MappleInitRes(Boolean bool, Boolean bool2, MapplePowInfo mapplePowInfo, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : bool2, (i & 4) != 0 ? null : mapplePowInfo, (i & 8) != 0 ? null : str);
    }

    @Nullable
    public final Boolean getSuccess() {
        return this.success;
    }

    @Nullable
    public final Boolean getRequiresPow() {
        return this.requiresPow;
    }

    @Nullable
    public final MapplePowInfo getPow() {
        return this.pow;
    }

    @Nullable
    public final String getToken() {
        return this.token;
    }
}
