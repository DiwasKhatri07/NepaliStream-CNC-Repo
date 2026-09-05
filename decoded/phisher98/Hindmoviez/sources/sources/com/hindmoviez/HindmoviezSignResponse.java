package com.hindmoviez;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Hindmoviez/classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/hindmoviez/HindmoviezSignResponse;", "", "success", "", "data", "Lcom/hindmoviez/HindmoviezSignData;", "<init>", "(ZLcom/hindmoviez/HindmoviezSignData;)V", "getSuccess", "()Z", "getData", "()Lcom/hindmoviez/HindmoviezSignData;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "Hindmoviez"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class HindmoviezSignResponse {

    @Nullable
    private final HindmoviezSignData data;
    private final boolean success;

    public static /* synthetic */ HindmoviezSignResponse copy$default(HindmoviezSignResponse hindmoviezSignResponse, boolean z, HindmoviezSignData hindmoviezSignData, int i, Object obj) {
        if ((i & 1) != 0) {
            z = hindmoviezSignResponse.success;
        }
        if ((i & 2) != 0) {
            hindmoviezSignData = hindmoviezSignResponse.data;
        }
        return hindmoviezSignResponse.copy(z, hindmoviezSignData);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final HindmoviezSignData getData() {
        return this.data;
    }

    @NotNull
    public final HindmoviezSignResponse copy(boolean success, @Nullable HindmoviezSignData data) {
        return new HindmoviezSignResponse(success, data);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HindmoviezSignResponse)) {
            return false;
        }
        HindmoviezSignResponse hindmoviezSignResponse = (HindmoviezSignResponse) other;
        return this.success == hindmoviezSignResponse.success && Intrinsics.areEqual(this.data, hindmoviezSignResponse.data);
    }

    public int hashCode() {
        return (HindmoviezSignResponse$$ExternalSyntheticBackport0.m0m(this.success) * 31) + (this.data == null ? 0 : this.data.hashCode());
    }

    @NotNull
    public String toString() {
        return "HindmoviezSignResponse(success=" + this.success + ", data=" + this.data + ')';
    }

    public HindmoviezSignResponse(boolean success, @Nullable HindmoviezSignData data) {
        this.success = success;
        this.data = data;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    @Nullable
    public final HindmoviezSignData getData() {
        return this.data;
    }
}
