package com.phisher98;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\u0002\b\u0012¨\u0006\u0011"}, d2 = {"Lcom/phisher98/EncryptedResponse;", "", "data", "Lcom/phisher98/EncryptedData;", "<init>", "(Lcom/phisher98/EncryptedData;)V", "getData", "()Lcom/phisher98/EncryptedData;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StreamPlay", "Lkotlinx/serialization/Serializable;"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class EncryptedResponse {

    @Nullable
    private final EncryptedData data;

    /* JADX WARN: Illegal instructions before constructor call */
    public EncryptedResponse() {
        EncryptedData encryptedData = null;
        this(encryptedData, 1, encryptedData);
    }

    public static /* synthetic */ EncryptedResponse copy$default(EncryptedResponse encryptedResponse, EncryptedData encryptedData, int i, Object obj) {
        if ((i & 1) != 0) {
            encryptedData = encryptedResponse.data;
        }
        return encryptedResponse.copy(encryptedData);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final EncryptedData getData() {
        return this.data;
    }

    @NotNull
    public final EncryptedResponse copy(@Nullable EncryptedData data) {
        return new EncryptedResponse(data);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof EncryptedResponse) && Intrinsics.areEqual(this.data, ((EncryptedResponse) other).data);
    }

    public int hashCode() {
        if (this.data == null) {
            return 0;
        }
        return this.data.hashCode();
    }

    @NotNull
    public String toString() {
        return "EncryptedResponse(data=" + this.data + ')';
    }

    public EncryptedResponse(@Nullable EncryptedData data) {
        this.data = data;
    }

    public /* synthetic */ EncryptedResponse(EncryptedData encryptedData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : encryptedData);
    }

    @Nullable
    public final EncryptedData getData() {
        return this.data;
    }
}
