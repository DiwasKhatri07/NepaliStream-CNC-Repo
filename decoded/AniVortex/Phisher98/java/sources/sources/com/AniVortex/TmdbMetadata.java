package com.AniVortex;

import com.lagradost.cloudstream3.ActorData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AniVortexTmdb.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/AniVortex/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\r\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0011\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\rHÆ\u0003J\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0092\u0001\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010.J\u0014\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00102\u001a\u00020\u0003HÖ\u0081\u0004J\n\u00103\u001a\u00020\u0005HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017¨\u00064"}, d2 = {"Lcom/AniVortex/TmdbMetadata;", "", "tmdbId", "", "imdbId", "", "logoUrl", "backdropUrl", "posterUrl", "overview", "rating", "", "genres", "", "actors", "Lcom/lagradost/cloudstream3/ActorData;", "trailerUrl", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getTmdbId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getImdbId", "()Ljava/lang/String;", "getLogoUrl", "getBackdropUrl", "getPosterUrl", "getOverview", "getRating", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getGenres", "()Ljava/util/List;", "getActors", "getTrailerUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)Lcom/AniVortex/TmdbMetadata;", "equals", "", "other", "hashCode", "toString", "AniVortex"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class TmdbMetadata {

    @Nullable
    private final List<ActorData> actors;

    @Nullable
    private final String backdropUrl;

    @Nullable
    private final List<String> genres;

    @Nullable
    private final String imdbId;

    @Nullable
    private final String logoUrl;

    @Nullable
    private final String overview;

    @Nullable
    private final String posterUrl;

    @Nullable
    private final Double rating;

    @Nullable
    private final Integer tmdbId;

    @Nullable
    private final String trailerUrl;

    public TmdbMetadata() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TmdbMetadata copy$default(TmdbMetadata tmdbMetadata, Integer num, String str, String str2, String str3, String str4, String str5, Double d, List list, List list2, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            num = tmdbMetadata.tmdbId;
        }
        if ((i & 2) != 0) {
            str = tmdbMetadata.imdbId;
        }
        if ((i & 4) != 0) {
            str2 = tmdbMetadata.logoUrl;
        }
        if ((i & 8) != 0) {
            str3 = tmdbMetadata.backdropUrl;
        }
        if ((i & 16) != 0) {
            str4 = tmdbMetadata.posterUrl;
        }
        if ((i & 32) != 0) {
            str5 = tmdbMetadata.overview;
        }
        if ((i & 64) != 0) {
            d = tmdbMetadata.rating;
        }
        if ((i & 128) != 0) {
            list = tmdbMetadata.genres;
        }
        if ((i & 256) != 0) {
            list2 = tmdbMetadata.actors;
        }
        if ((i & 512) != 0) {
            str6 = tmdbMetadata.trailerUrl;
        }
        List list3 = list2;
        String str7 = str6;
        Double d2 = d;
        List list4 = list;
        String str8 = str4;
        String str9 = str5;
        return tmdbMetadata.copy(num, str, str2, str3, str8, str9, d2, list4, list3, str7);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getTmdbId() {
        return this.tmdbId;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getTrailerUrl() {
        return this.trailerUrl;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getImdbId() {
        return this.imdbId;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getBackdropUrl() {
        return this.backdropUrl;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPosterUrl() {
        return this.posterUrl;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getOverview() {
        return this.overview;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Double getRating() {
        return this.rating;
    }

    @Nullable
    public final List<String> component8() {
        return this.genres;
    }

    @Nullable
    public final List<ActorData> component9() {
        return this.actors;
    }

    @NotNull
    public final TmdbMetadata copy(@Nullable Integer tmdbId, @Nullable String imdbId, @Nullable String logoUrl, @Nullable String backdropUrl, @Nullable String posterUrl, @Nullable String overview, @Nullable Double rating, @Nullable List<String> genres, @Nullable List<ActorData> actors, @Nullable String trailerUrl) {
        return new TmdbMetadata(tmdbId, imdbId, logoUrl, backdropUrl, posterUrl, overview, rating, genres, actors, trailerUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TmdbMetadata)) {
            return false;
        }
        TmdbMetadata tmdbMetadata = (TmdbMetadata) other;
        return Intrinsics.areEqual(this.tmdbId, tmdbMetadata.tmdbId) && Intrinsics.areEqual(this.imdbId, tmdbMetadata.imdbId) && Intrinsics.areEqual(this.logoUrl, tmdbMetadata.logoUrl) && Intrinsics.areEqual(this.backdropUrl, tmdbMetadata.backdropUrl) && Intrinsics.areEqual(this.posterUrl, tmdbMetadata.posterUrl) && Intrinsics.areEqual(this.overview, tmdbMetadata.overview) && Intrinsics.areEqual(this.rating, tmdbMetadata.rating) && Intrinsics.areEqual(this.genres, tmdbMetadata.genres) && Intrinsics.areEqual(this.actors, tmdbMetadata.actors) && Intrinsics.areEqual(this.trailerUrl, tmdbMetadata.trailerUrl);
    }

    public int hashCode() {
        return ((((((((((((((((((this.tmdbId == null ? 0 : this.tmdbId.hashCode()) * 31) + (this.imdbId == null ? 0 : this.imdbId.hashCode())) * 31) + (this.logoUrl == null ? 0 : this.logoUrl.hashCode())) * 31) + (this.backdropUrl == null ? 0 : this.backdropUrl.hashCode())) * 31) + (this.posterUrl == null ? 0 : this.posterUrl.hashCode())) * 31) + (this.overview == null ? 0 : this.overview.hashCode())) * 31) + (this.rating == null ? 0 : this.rating.hashCode())) * 31) + (this.genres == null ? 0 : this.genres.hashCode())) * 31) + (this.actors == null ? 0 : this.actors.hashCode())) * 31) + (this.trailerUrl != null ? this.trailerUrl.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "TmdbMetadata(tmdbId=" + this.tmdbId + ", imdbId=" + this.imdbId + ", logoUrl=" + this.logoUrl + ", backdropUrl=" + this.backdropUrl + ", posterUrl=" + this.posterUrl + ", overview=" + this.overview + ", rating=" + this.rating + ", genres=" + this.genres + ", actors=" + this.actors + ", trailerUrl=" + this.trailerUrl + ')';
    }

    public TmdbMetadata(@Nullable Integer tmdbId, @Nullable String imdbId, @Nullable String logoUrl, @Nullable String backdropUrl, @Nullable String posterUrl, @Nullable String overview, @Nullable Double rating, @Nullable List<String> list, @Nullable List<ActorData> list2, @Nullable String trailerUrl) {
        this.tmdbId = tmdbId;
        this.imdbId = imdbId;
        this.logoUrl = logoUrl;
        this.backdropUrl = backdropUrl;
        this.posterUrl = posterUrl;
        this.overview = overview;
        this.rating = rating;
        this.genres = list;
        this.actors = list2;
        this.trailerUrl = trailerUrl;
    }

    public /* synthetic */ TmdbMetadata(Integer num, String str, String str2, String str3, String str4, String str5, Double d, List list, List list2, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : d, (i & 128) != 0 ? null : list, (i & 256) != 0 ? null : list2, (i & 512) != 0 ? null : str6);
    }

    @Nullable
    public final Integer getTmdbId() {
        return this.tmdbId;
    }

    @Nullable
    public final String getImdbId() {
        return this.imdbId;
    }

    @Nullable
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    @Nullable
    public final String getBackdropUrl() {
        return this.backdropUrl;
    }

    @Nullable
    public final String getPosterUrl() {
        return this.posterUrl;
    }

    @Nullable
    public final String getOverview() {
        return this.overview;
    }

    @Nullable
    public final Double getRating() {
        return this.rating;
    }

    @Nullable
    public final List<String> getGenres() {
        return this.genres;
    }

    @Nullable
    public final List<ActorData> getActors() {
        return this.actors;
    }

    @Nullable
    public final String getTrailerUrl() {
        return this.trailerUrl;
    }
}
