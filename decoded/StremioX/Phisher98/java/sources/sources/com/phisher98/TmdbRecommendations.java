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
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u001e\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\f\u001a\u00020\u00002\u001e\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/phisher98/TmdbRecommendations;", "", "results", "", "Lcom/phisher98/TmdbMedia;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Ljava/util/List;)V", "getResults", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
final /* data */ class TmdbRecommendations {

    @Nullable
    private final List<TmdbMedia> results;

    /* JADX WARN: Illegal instructions before constructor call */
    public TmdbRecommendations() {
        List list = null;
        this(list, 1, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TmdbRecommendations copy$default(TmdbRecommendations tmdbRecommendations, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = tmdbRecommendations.results;
        }
        return tmdbRecommendations.copy(list);
    }

    @Nullable
    public final List<TmdbMedia> component1() {
        return this.results;
    }

    @NotNull
    public final TmdbRecommendations copy(@JsonProperty("results") @Nullable List<TmdbMedia> results) {
        return new TmdbRecommendations(results);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof TmdbRecommendations) && Intrinsics.areEqual(this.results, ((TmdbRecommendations) other).results);
    }

    public int hashCode() {
        if (this.results == null) {
            return 0;
        }
        return this.results.hashCode();
    }

    @NotNull
    public String toString() {
        return "TmdbRecommendations(results=" + this.results + ')';
    }

    public TmdbRecommendations(@JsonProperty("results") @Nullable List<TmdbMedia> list) {
        this.results = list;
    }

    public /* synthetic */ TmdbRecommendations(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list);
    }

    @Nullable
    public final List<TmdbMedia> getResults() {
        return this.results;
    }
}
