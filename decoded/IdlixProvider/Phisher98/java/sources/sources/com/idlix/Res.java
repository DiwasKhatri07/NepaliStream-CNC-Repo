package com.idlix;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: IdlixProvider.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/IdlixProvider/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/idlix/Res;", "", "gateToken", "", "serverNow", "", "unlockAt", "<init>", "(Ljava/lang/String;JJ)V", "getGateToken", "()Ljava/lang/String;", "getServerNow", "()J", "getUnlockAt", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "IdlixProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Res {

    @NotNull
    private final String gateToken;
    private final long serverNow;
    private final long unlockAt;

    public static /* synthetic */ Res copy$default(Res res, String str, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = res.gateToken;
        }
        if ((i & 2) != 0) {
            j = res.serverNow;
        }
        if ((i & 4) != 0) {
            j2 = res.unlockAt;
        }
        return res.copy(str, j, j2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getGateToken() {
        return this.gateToken;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getServerNow() {
        return this.serverNow;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getUnlockAt() {
        return this.unlockAt;
    }

    @NotNull
    public final Res copy(@NotNull String gateToken, long serverNow, long unlockAt) {
        return new Res(gateToken, serverNow, unlockAt);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Res)) {
            return false;
        }
        Res res = (Res) other;
        return Intrinsics.areEqual(this.gateToken, res.gateToken) && this.serverNow == res.serverNow && this.unlockAt == res.unlockAt;
    }

    public int hashCode() {
        return (((this.gateToken.hashCode() * 31) + Res$$ExternalSyntheticBackport0.m2m(this.serverNow)) * 31) + Res$$ExternalSyntheticBackport0.m2m(this.unlockAt);
    }

    @NotNull
    public String toString() {
        return "Res(gateToken=" + this.gateToken + ", serverNow=" + this.serverNow + ", unlockAt=" + this.unlockAt + ')';
    }

    public Res(@NotNull String gateToken, long serverNow, long unlockAt) {
        this.gateToken = gateToken;
        this.serverNow = serverNow;
        this.unlockAt = unlockAt;
    }

    @NotNull
    public final String getGateToken() {
        return this.gateToken;
    }

    public final long getServerNow() {
        return this.serverNow;
    }

    public final long getUnlockAt() {
        return this.unlockAt;
    }
}
