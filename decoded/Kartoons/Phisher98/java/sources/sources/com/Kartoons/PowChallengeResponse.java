package com.Kartoons;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Kartoons.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Kartoons/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/Kartoons/PowChallengeResponse;", "", "success", "", "data", "Lcom/Kartoons/PowChallengeData;", "<init>", "(ZLcom/Kartoons/PowChallengeData;)V", "getSuccess", "()Z", "getData", "()Lcom/Kartoons/PowChallengeData;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "Kartoons"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class PowChallengeResponse {

    @Nullable
    private final PowChallengeData data;
    private final boolean success;

    public static /* synthetic */ PowChallengeResponse copy$default(PowChallengeResponse powChallengeResponse, boolean z, PowChallengeData powChallengeData, int i, Object obj) {
        if ((i & 1) != 0) {
            z = powChallengeResponse.success;
        }
        if ((i & 2) != 0) {
            powChallengeData = powChallengeResponse.data;
        }
        return powChallengeResponse.copy(z, powChallengeData);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final PowChallengeData getData() {
        return this.data;
    }

    @NotNull
    public final PowChallengeResponse copy(boolean success, @Nullable PowChallengeData data) {
        return new PowChallengeResponse(success, data);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PowChallengeResponse)) {
            return false;
        }
        PowChallengeResponse powChallengeResponse = (PowChallengeResponse) other;
        return this.success == powChallengeResponse.success && Intrinsics.areEqual(this.data, powChallengeResponse.data);
    }

    public int hashCode() {
        return (PowChallengeResponse$$ExternalSyntheticBackport0.m1m(this.success) * 31) + (this.data == null ? 0 : this.data.hashCode());
    }

    @NotNull
    public String toString() {
        return "PowChallengeResponse(success=" + this.success + ", data=" + this.data + ')';
    }

    public PowChallengeResponse(boolean success, @Nullable PowChallengeData data) {
        this.success = success;
        this.data = data;
    }

    @Nullable
    public final PowChallengeData getData() {
        return this.data;
    }

    public final boolean getSuccess() {
        return this.success;
    }
}
