package com.IStreamFlare;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: IStreamFlareParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/IStreamFlare/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/IStreamFlare/Response;", "", "encrypted", "", "data", "", "<init>", "(ZLjava/lang/String;)V", "getEncrypted", "()Z", "getData", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "IStreamFlare"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Response {

    @NotNull
    private final String data;
    private final boolean encrypted;

    public static /* synthetic */ Response copy$default(Response response, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = response.encrypted;
        }
        if ((i & 2) != 0) {
            str = response.data;
        }
        return response.copy(z, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getEncrypted() {
        return this.encrypted;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getData() {
        return this.data;
    }

    @NotNull
    public final Response copy(boolean encrypted, @NotNull String data) {
        return new Response(encrypted, data);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Response)) {
            return false;
        }
        Response response = (Response) other;
        return this.encrypted == response.encrypted && Intrinsics.areEqual(this.data, response.data);
    }

    public int hashCode() {
        return (Response$$ExternalSyntheticBackport0.m0m(this.encrypted) * 31) + this.data.hashCode();
    }

    @NotNull
    public String toString() {
        return "Response(encrypted=" + this.encrypted + ", data=" + this.data + ')';
    }

    public Response(boolean encrypted, @NotNull String data) {
        this.encrypted = encrypted;
        this.data = data;
    }

    public final boolean getEncrypted() {
        return this.encrypted;
    }

    @NotNull
    public final String getData() {
        return this.data;
    }
}
