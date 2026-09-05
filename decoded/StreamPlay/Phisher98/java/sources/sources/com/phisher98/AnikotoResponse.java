package com.phisher98;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0005HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/phisher98/AnikotoResponse;", "", "status", "", "result", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getResult", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/phisher98/AnikotoResponse;", "equals", "", "other", "hashCode", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class AnikotoResponse {

    @Nullable
    private final String result;

    @Nullable
    private final Integer status;

    /* JADX WARN: Multi-variable type inference failed */
    public AnikotoResponse() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ AnikotoResponse copy$default(AnikotoResponse anikotoResponse, Integer num, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            num = anikotoResponse.status;
        }
        if ((i & 2) != 0) {
            str = anikotoResponse.result;
        }
        return anikotoResponse.copy(num, str);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getStatus() {
        return this.status;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getResult() {
        return this.result;
    }

    @NotNull
    public final AnikotoResponse copy(@Nullable Integer status, @Nullable String result) {
        return new AnikotoResponse(status, result);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnikotoResponse)) {
            return false;
        }
        AnikotoResponse anikotoResponse = (AnikotoResponse) other;
        return Intrinsics.areEqual(this.status, anikotoResponse.status) && Intrinsics.areEqual(this.result, anikotoResponse.result);
    }

    public int hashCode() {
        return ((this.status == null ? 0 : this.status.hashCode()) * 31) + (this.result != null ? this.result.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "AnikotoResponse(status=" + this.status + ", result=" + this.result + ')';
    }

    public AnikotoResponse(@Nullable Integer status, @Nullable String result) {
        this.status = status;
        this.result = result;
    }

    public /* synthetic */ AnikotoResponse(Integer num, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str);
    }

    @Nullable
    public final Integer getStatus() {
        return this.status;
    }

    @Nullable
    public final String getResult() {
        return this.result;
    }
}
