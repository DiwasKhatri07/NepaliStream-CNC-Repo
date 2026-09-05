package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StremioC.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StremioX/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B!\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J#\u0010\u000b\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/phisher98/TmdbDetailResponse;", "", "recommendations", "Lcom/phisher98/TmdbRecommendations;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Lcom/phisher98/TmdbRecommendations;)V", "getRecommendations", "()Lcom/phisher98/TmdbRecommendations;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
final /* data */ class TmdbDetailResponse {

    @Nullable
    private final TmdbRecommendations recommendations;

    /* JADX WARN: Illegal instructions before constructor call */
    public TmdbDetailResponse() {
        TmdbRecommendations tmdbRecommendations = null;
        this(tmdbRecommendations, 1, tmdbRecommendations);
    }

    public static /* synthetic */ TmdbDetailResponse copy$default(TmdbDetailResponse tmdbDetailResponse, TmdbRecommendations tmdbRecommendations, int i, Object obj) {
        if ((i & 1) != 0) {
            tmdbRecommendations = tmdbDetailResponse.recommendations;
        }
        return tmdbDetailResponse.copy(tmdbRecommendations);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final TmdbRecommendations getRecommendations() {
        return this.recommendations;
    }

    @NotNull
    public final TmdbDetailResponse copy(@JsonProperty("recommendations") @Nullable TmdbRecommendations recommendations) {
        return new TmdbDetailResponse(recommendations);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof TmdbDetailResponse) && Intrinsics.areEqual(this.recommendations, ((TmdbDetailResponse) other).recommendations);
    }

    public int hashCode() {
        if (this.recommendations == null) {
            return 0;
        }
        return this.recommendations.hashCode();
    }

    @NotNull
    public String toString() {
        return "TmdbDetailResponse(recommendations=" + this.recommendations + ')';
    }

    public TmdbDetailResponse(@JsonProperty("recommendations") @Nullable TmdbRecommendations recommendations) {
        this.recommendations = recommendations;
    }

    public /* synthetic */ TmdbDetailResponse(TmdbRecommendations tmdbRecommendations, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : tmdbRecommendations);
    }

    @Nullable
    public final TmdbRecommendations getRecommendations() {
        return this.recommendations;
    }
}
