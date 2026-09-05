package com.Kartoons;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Kartoons.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Kartoons/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0014\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\bHÖ\u0081\u0004J\n\u0010\u001d\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/Kartoons/PowChallengeData;", "", "enabled", "", "nonce", "", "algo", "bits", "", "ttl", "<init>", "(ZLjava/lang/String;Ljava/lang/String;II)V", "getEnabled", "()Z", "getNonce", "()Ljava/lang/String;", "getAlgo", "getBits", "()I", "getTtl", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "Kartoons"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class PowChallengeData {

    @NotNull
    private final String algo;
    private final int bits;
    private final boolean enabled;

    @NotNull
    private final String nonce;
    private final int ttl;

    public static /* synthetic */ PowChallengeData copy$default(PowChallengeData powChallengeData, boolean z, String str, String str2, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z = powChallengeData.enabled;
        }
        if ((i3 & 2) != 0) {
            str = powChallengeData.nonce;
        }
        if ((i3 & 4) != 0) {
            str2 = powChallengeData.algo;
        }
        if ((i3 & 8) != 0) {
            i = powChallengeData.bits;
        }
        if ((i3 & 16) != 0) {
            i2 = powChallengeData.ttl;
        }
        int i4 = i2;
        String str3 = str2;
        return powChallengeData.copy(z, str, str3, i, i4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getNonce() {
        return this.nonce;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAlgo() {
        return this.algo;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getBits() {
        return this.bits;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getTtl() {
        return this.ttl;
    }

    @NotNull
    public final PowChallengeData copy(boolean enabled, @NotNull String nonce, @NotNull String algo, int bits, int ttl) {
        return new PowChallengeData(enabled, nonce, algo, bits, ttl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PowChallengeData)) {
            return false;
        }
        PowChallengeData powChallengeData = (PowChallengeData) other;
        return this.enabled == powChallengeData.enabled && Intrinsics.areEqual(this.nonce, powChallengeData.nonce) && Intrinsics.areEqual(this.algo, powChallengeData.algo) && this.bits == powChallengeData.bits && this.ttl == powChallengeData.ttl;
    }

    public int hashCode() {
        return (((((((PowChallengeData$$ExternalSyntheticBackport0.m0m(this.enabled) * 31) + this.nonce.hashCode()) * 31) + this.algo.hashCode()) * 31) + this.bits) * 31) + this.ttl;
    }

    @NotNull
    public String toString() {
        return "PowChallengeData(enabled=" + this.enabled + ", nonce=" + this.nonce + ", algo=" + this.algo + ", bits=" + this.bits + ", ttl=" + this.ttl + ')';
    }

    public PowChallengeData(boolean enabled, @NotNull String nonce, @NotNull String algo, int bits, int ttl) {
        this.enabled = enabled;
        this.nonce = nonce;
        this.algo = algo;
        this.bits = bits;
        this.ttl = ttl;
    }

    @NotNull
    public final String getAlgo() {
        return this.algo;
    }

    public final int getBits() {
        return this.bits;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    @NotNull
    public final String getNonce() {
        return this.nonce;
    }

    public final int getTtl() {
        return this.ttl;
    }
}
