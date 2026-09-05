package com.phisher98;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u0007HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/phisher98/VidFastRes;", "", "status", "", "result", "Lcom/phisher98/VidFastResult;", "info", "", "<init>", "(JLcom/phisher98/VidFastResult;Ljava/lang/String;)V", "getStatus", "()J", "getResult", "()Lcom/phisher98/VidFastResult;", "getInfo", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class VidFastRes {

    @NotNull
    private final String info;

    @NotNull
    private final VidFastResult result;
    private final long status;

    public static /* synthetic */ VidFastRes copy$default(VidFastRes vidFastRes, long j, VidFastResult vidFastResult, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            j = vidFastRes.status;
        }
        if ((i & 2) != 0) {
            vidFastResult = vidFastRes.result;
        }
        if ((i & 4) != 0) {
            str = vidFastRes.info;
        }
        return vidFastRes.copy(j, vidFastResult, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getStatus() {
        return this.status;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final VidFastResult getResult() {
        return this.result;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getInfo() {
        return this.info;
    }

    @NotNull
    public final VidFastRes copy(long status, @NotNull VidFastResult result, @NotNull String info) {
        return new VidFastRes(status, result, info);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VidFastRes)) {
            return false;
        }
        VidFastRes vidFastRes = (VidFastRes) other;
        return this.status == vidFastRes.status && Intrinsics.areEqual(this.result, vidFastRes.result) && Intrinsics.areEqual(this.info, vidFastRes.info);
    }

    public int hashCode() {
        return (((VidFastRes$$ExternalSyntheticBackport0.m35m(this.status) * 31) + this.result.hashCode()) * 31) + this.info.hashCode();
    }

    @NotNull
    public String toString() {
        return "VidFastRes(status=" + this.status + ", result=" + this.result + ", info=" + this.info + ')';
    }

    public VidFastRes(long status, @NotNull VidFastResult result, @NotNull String info) {
        this.status = status;
        this.result = result;
        this.info = info;
    }

    public final long getStatus() {
        return this.status;
    }

    @NotNull
    public final VidFastResult getResult() {
        return this.result;
    }

    @NotNull
    public final String getInfo() {
        return this.info;
    }
}
