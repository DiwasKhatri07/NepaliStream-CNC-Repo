package com.phisher98;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/phisher98/FsonicRes;", "", "status", "", "data", "Lcom/phisher98/FsonicData;", "<init>", "(Ljava/lang/String;Lcom/phisher98/FsonicData;)V", "getStatus", "()Ljava/lang/String;", "getData", "()Lcom/phisher98/FsonicData;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class FsonicRes {

    @Nullable
    private final FsonicData data;

    @Nullable
    private final String status;

    /* JADX WARN: Multi-variable type inference failed */
    public FsonicRes() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ FsonicRes copy$default(FsonicRes fsonicRes, String str, FsonicData fsonicData, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fsonicRes.status;
        }
        if ((i & 2) != 0) {
            fsonicData = fsonicRes.data;
        }
        return fsonicRes.copy(str, fsonicData);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final FsonicData getData() {
        return this.data;
    }

    @NotNull
    public final FsonicRes copy(@Nullable String status, @Nullable FsonicData data) {
        return new FsonicRes(status, data);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FsonicRes)) {
            return false;
        }
        FsonicRes fsonicRes = (FsonicRes) other;
        return Intrinsics.areEqual(this.status, fsonicRes.status) && Intrinsics.areEqual(this.data, fsonicRes.data);
    }

    public int hashCode() {
        return ((this.status == null ? 0 : this.status.hashCode()) * 31) + (this.data != null ? this.data.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "FsonicRes(status=" + this.status + ", data=" + this.data + ')';
    }

    public FsonicRes(@Nullable String status, @Nullable FsonicData data) {
        this.status = status;
        this.data = data;
    }

    public /* synthetic */ FsonicRes(String str, FsonicData fsonicData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : fsonicData);
    }

    @Nullable
    public final String getStatus() {
        return this.status;
    }

    @Nullable
    public final FsonicData getData() {
        return this.data;
    }
}
