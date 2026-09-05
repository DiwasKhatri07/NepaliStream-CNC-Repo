package com.hdhub4u;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/HDhub4u/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R'\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/hdhub4u/IMDB;", "", "imdbId", "", "<init>", "(Ljava/lang/String;)V", "getImdbId", "()Ljava/lang/String;", "Lcom/google/gson/annotations/SerializedName;", "value", "imdb_id", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "HDhub4u"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class IMDB {

    @SerializedName("imdb_id")
    @Nullable
    private final String imdbId;

    /* JADX WARN: Illegal instructions before constructor call */
    public IMDB() {
        String str = null;
        this(str, 1, str);
    }

    public static /* synthetic */ IMDB copy$default(IMDB imdb, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = imdb.imdbId;
        }
        return imdb.copy(str);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getImdbId() {
        return this.imdbId;
    }

    @NotNull
    public final IMDB copy(@Nullable String imdbId) {
        return new IMDB(imdbId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof IMDB) && Intrinsics.areEqual(this.imdbId, ((IMDB) other).imdbId);
    }

    public int hashCode() {
        if (this.imdbId == null) {
            return 0;
        }
        return this.imdbId.hashCode();
    }

    @NotNull
    public String toString() {
        return "IMDB(imdbId=" + this.imdbId + ')';
    }

    public IMDB(@Nullable String imdbId) {
        this.imdbId = imdbId;
    }

    public /* synthetic */ IMDB(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    @Nullable
    public final String getImdbId() {
        return this.imdbId;
    }
}
