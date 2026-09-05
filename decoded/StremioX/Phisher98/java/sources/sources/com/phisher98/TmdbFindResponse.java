package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StremioC.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StremioX/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001BG\u0012\u001e\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002\u0012\u001e\b\u0003\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003JI\u0010\u000f\u001a\u00020\u00002\u001e\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u00022\u001e\b\u0003\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/phisher98/TmdbFindResponse;", "", "movie_results", "", "Lcom/phisher98/TmdbFindResult;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "tv_results", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getMovie_results", "()Ljava/util/List;", "getTv_results", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
final /* data */ class TmdbFindResponse {

    @Nullable
    private final List<TmdbFindResult> movie_results;

    @Nullable
    private final List<TmdbFindResult> tv_results;

    /* JADX WARN: Illegal instructions before constructor call */
    public TmdbFindResponse() {
        List list = null;
        this(list, list, 3, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TmdbFindResponse copy$default(TmdbFindResponse tmdbFindResponse, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = tmdbFindResponse.movie_results;
        }
        if ((i & 2) != 0) {
            list2 = tmdbFindResponse.tv_results;
        }
        return tmdbFindResponse.copy(list, list2);
    }

    @Nullable
    public final List<TmdbFindResult> component1() {
        return this.movie_results;
    }

    @Nullable
    public final List<TmdbFindResult> component2() {
        return this.tv_results;
    }

    @NotNull
    public final TmdbFindResponse copy(@JsonProperty("movie_results") @Nullable List<TmdbFindResult> movie_results, @JsonProperty("tv_results") @Nullable List<TmdbFindResult> tv_results) {
        return new TmdbFindResponse(movie_results, tv_results);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TmdbFindResponse)) {
            return false;
        }
        TmdbFindResponse tmdbFindResponse = (TmdbFindResponse) other;
        return Intrinsics.areEqual(this.movie_results, tmdbFindResponse.movie_results) && Intrinsics.areEqual(this.tv_results, tmdbFindResponse.tv_results);
    }

    public int hashCode() {
        return ((this.movie_results == null ? 0 : this.movie_results.hashCode()) * 31) + (this.tv_results != null ? this.tv_results.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "TmdbFindResponse(movie_results=" + this.movie_results + ", tv_results=" + this.tv_results + ')';
    }

    public TmdbFindResponse(@JsonProperty("movie_results") @Nullable List<TmdbFindResult> list, @JsonProperty("tv_results") @Nullable List<TmdbFindResult> list2) {
        this.movie_results = list;
        this.tv_results = list2;
    }

    public /* synthetic */ TmdbFindResponse(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2);
    }

    @Nullable
    public final List<TmdbFindResult> getMovie_results() {
        return this.movie_results;
    }

    @Nullable
    public final List<TmdbFindResult> getTv_results() {
        return this.tv_results;
    }
}
