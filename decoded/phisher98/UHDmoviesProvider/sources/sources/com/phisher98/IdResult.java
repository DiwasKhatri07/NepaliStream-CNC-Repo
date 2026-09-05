package com.phisher98;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: UHDmoviesProvider.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/UHDmoviesProvider/classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0005HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/phisher98/IdResult;", "", "tmdbId", "", "imdbId", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getTmdbId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getImdbId", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/phisher98/IdResult;", "equals", "", "other", "hashCode", "toString", "UHDmoviesProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class IdResult {

    @Nullable
    private final String imdbId;

    @Nullable
    private final Integer tmdbId;

    public static /* synthetic */ IdResult copy$default(IdResult idResult, Integer num, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            num = idResult.tmdbId;
        }
        if ((i & 2) != 0) {
            str = idResult.imdbId;
        }
        return idResult.copy(num, str);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getTmdbId() {
        return this.tmdbId;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getImdbId() {
        return this.imdbId;
    }

    @NotNull
    public final IdResult copy(@Nullable Integer tmdbId, @Nullable String imdbId) {
        return new IdResult(tmdbId, imdbId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IdResult)) {
            return false;
        }
        IdResult idResult = (IdResult) other;
        return Intrinsics.areEqual(this.tmdbId, idResult.tmdbId) && Intrinsics.areEqual(this.imdbId, idResult.imdbId);
    }

    public int hashCode() {
        return ((this.tmdbId == null ? 0 : this.tmdbId.hashCode()) * 31) + (this.imdbId != null ? this.imdbId.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "IdResult(tmdbId=" + this.tmdbId + ", imdbId=" + this.imdbId + ')';
    }

    public IdResult(@Nullable Integer tmdbId, @Nullable String imdbId) {
        this.tmdbId = tmdbId;
        this.imdbId = imdbId;
    }

    @Nullable
    public final Integer getTmdbId() {
        return this.tmdbId;
    }

    @Nullable
    public final String getImdbId() {
        return this.imdbId;
    }
}
