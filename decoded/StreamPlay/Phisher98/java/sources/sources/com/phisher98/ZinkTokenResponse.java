package com.phisher98;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/phisher98/ZinkTokenResponse;", "", "status", "", "token", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getStatus", "()Ljava/lang/String;", "getToken", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class ZinkTokenResponse {

    @Nullable
    private final String status;

    @Nullable
    private final String token;

    /* JADX WARN: Illegal instructions before constructor call */
    public ZinkTokenResponse() {
        String str = null;
        this(str, str, 3, str);
    }

    public static /* synthetic */ ZinkTokenResponse copy$default(ZinkTokenResponse zinkTokenResponse, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = zinkTokenResponse.status;
        }
        if ((i & 2) != 0) {
            str2 = zinkTokenResponse.token;
        }
        return zinkTokenResponse.copy(str, str2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    @NotNull
    public final ZinkTokenResponse copy(@Nullable String status, @Nullable String token) {
        return new ZinkTokenResponse(status, token);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZinkTokenResponse)) {
            return false;
        }
        ZinkTokenResponse zinkTokenResponse = (ZinkTokenResponse) other;
        return Intrinsics.areEqual(this.status, zinkTokenResponse.status) && Intrinsics.areEqual(this.token, zinkTokenResponse.token);
    }

    public int hashCode() {
        return ((this.status == null ? 0 : this.status.hashCode()) * 31) + (this.token != null ? this.token.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ZinkTokenResponse(status=" + this.status + ", token=" + this.token + ')';
    }

    public ZinkTokenResponse(@Nullable String status, @Nullable String token) {
        this.status = status;
        this.token = token;
    }

    public /* synthetic */ ZinkTokenResponse(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    @Nullable
    public final String getStatus() {
        return this.status;
    }

    @Nullable
    public final String getToken() {
        return this.token;
    }
}
