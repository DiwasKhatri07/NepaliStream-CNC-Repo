package com.phisher98;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: XDMoviesParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/XDMovies/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/phisher98/ResponseData;", "", "meta", "Lcom/phisher98/Meta;", "<init>", "(Lcom/phisher98/Meta;)V", "getMeta", "()Lcom/phisher98/Meta;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "XDMovies"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class ResponseData {

    @Nullable
    private final Meta meta;

    public static /* synthetic */ ResponseData copy$default(ResponseData responseData, Meta meta, int i, Object obj) {
        if ((i & 1) != 0) {
            meta = responseData.meta;
        }
        return responseData.copy(meta);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Meta getMeta() {
        return this.meta;
    }

    @NotNull
    public final ResponseData copy(@Nullable Meta meta) {
        return new ResponseData(meta);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ResponseData) && Intrinsics.areEqual(this.meta, ((ResponseData) other).meta);
    }

    public int hashCode() {
        if (this.meta == null) {
            return 0;
        }
        return this.meta.hashCode();
    }

    @NotNull
    public String toString() {
        return "ResponseData(meta=" + this.meta + ')';
    }

    public ResponseData(@Nullable Meta meta) {
        this.meta = meta;
    }

    @Nullable
    public final Meta getMeta() {
        return this.meta;
    }
}
