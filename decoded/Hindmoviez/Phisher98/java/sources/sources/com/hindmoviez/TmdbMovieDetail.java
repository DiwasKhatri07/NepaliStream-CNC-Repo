package com.hindmoviez;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Hindmoviez/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001By\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0011\u0010*\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0080\u0001\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u0010-J\u0014\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00101\u001a\u00020\u0003HÖ\u0081\u0004J\n\u00102\u001a\u00020\u0005HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u00063"}, d2 = {"Lcom/hindmoviez/TmdbMovieDetail;", "", "id", "", "title", "", "overview", "poster_path", "backdrop_path", "release_date", "vote_average", "", "genres", "", "Lcom/hindmoviez/TmdbGenre;", "images", "Lcom/hindmoviez/TmdbImages;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/util/List;Lcom/hindmoviez/TmdbImages;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTitle", "()Ljava/lang/String;", "getOverview", "getPoster_path", "getBackdrop_path", "getRelease_date", "getVote_average", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getGenres", "()Ljava/util/List;", "getImages", "()Lcom/hindmoviez/TmdbImages;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/util/List;Lcom/hindmoviez/TmdbImages;)Lcom/hindmoviez/TmdbMovieDetail;", "equals", "", "other", "hashCode", "toString", "Hindmoviez"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class TmdbMovieDetail {

    @Nullable
    private final String backdrop_path;

    @Nullable
    private final List<TmdbGenre> genres;

    @Nullable
    private final Integer id;

    @Nullable
    private final TmdbImages images;

    @Nullable
    private final String overview;

    @Nullable
    private final String poster_path;

    @Nullable
    private final String release_date;

    @Nullable
    private final String title;

    @Nullable
    private final Double vote_average;

    public TmdbMovieDetail() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TmdbMovieDetail copy$default(TmdbMovieDetail tmdbMovieDetail, Integer num, String str, String str2, String str3, String str4, String str5, Double d, List list, TmdbImages tmdbImages, int i, Object obj) {
        if ((i & 1) != 0) {
            num = tmdbMovieDetail.id;
        }
        if ((i & 2) != 0) {
            str = tmdbMovieDetail.title;
        }
        if ((i & 4) != 0) {
            str2 = tmdbMovieDetail.overview;
        }
        if ((i & 8) != 0) {
            str3 = tmdbMovieDetail.poster_path;
        }
        if ((i & 16) != 0) {
            str4 = tmdbMovieDetail.backdrop_path;
        }
        if ((i & 32) != 0) {
            str5 = tmdbMovieDetail.release_date;
        }
        if ((i & 64) != 0) {
            d = tmdbMovieDetail.vote_average;
        }
        if ((i & 128) != 0) {
            list = tmdbMovieDetail.genres;
        }
        if ((i & 256) != 0) {
            tmdbImages = tmdbMovieDetail.images;
        }
        List list2 = list;
        TmdbImages tmdbImages2 = tmdbImages;
        String str6 = str5;
        Double d2 = d;
        String str7 = str4;
        String str8 = str2;
        return tmdbMovieDetail.copy(num, str, str8, str3, str7, str6, d2, list2, tmdbImages2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getOverview() {
        return this.overview;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPoster_path() {
        return this.poster_path;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getBackdrop_path() {
        return this.backdrop_path;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getRelease_date() {
        return this.release_date;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Double getVote_average() {
        return this.vote_average;
    }

    @Nullable
    public final List<TmdbGenre> component8() {
        return this.genres;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final TmdbImages getImages() {
        return this.images;
    }

    @NotNull
    public final TmdbMovieDetail copy(@Nullable Integer id, @Nullable String title, @Nullable String overview, @Nullable String poster_path, @Nullable String backdrop_path, @Nullable String release_date, @Nullable Double vote_average, @Nullable List<TmdbGenre> genres, @Nullable TmdbImages images) {
        return new TmdbMovieDetail(id, title, overview, poster_path, backdrop_path, release_date, vote_average, genres, images);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TmdbMovieDetail)) {
            return false;
        }
        TmdbMovieDetail tmdbMovieDetail = (TmdbMovieDetail) other;
        return Intrinsics.areEqual(this.id, tmdbMovieDetail.id) && Intrinsics.areEqual(this.title, tmdbMovieDetail.title) && Intrinsics.areEqual(this.overview, tmdbMovieDetail.overview) && Intrinsics.areEqual(this.poster_path, tmdbMovieDetail.poster_path) && Intrinsics.areEqual(this.backdrop_path, tmdbMovieDetail.backdrop_path) && Intrinsics.areEqual(this.release_date, tmdbMovieDetail.release_date) && Intrinsics.areEqual(this.vote_average, tmdbMovieDetail.vote_average) && Intrinsics.areEqual(this.genres, tmdbMovieDetail.genres) && Intrinsics.areEqual(this.images, tmdbMovieDetail.images);
    }

    public int hashCode() {
        return ((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.overview == null ? 0 : this.overview.hashCode())) * 31) + (this.poster_path == null ? 0 : this.poster_path.hashCode())) * 31) + (this.backdrop_path == null ? 0 : this.backdrop_path.hashCode())) * 31) + (this.release_date == null ? 0 : this.release_date.hashCode())) * 31) + (this.vote_average == null ? 0 : this.vote_average.hashCode())) * 31) + (this.genres == null ? 0 : this.genres.hashCode())) * 31) + (this.images != null ? this.images.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "TmdbMovieDetail(id=" + this.id + ", title=" + this.title + ", overview=" + this.overview + ", poster_path=" + this.poster_path + ", backdrop_path=" + this.backdrop_path + ", release_date=" + this.release_date + ", vote_average=" + this.vote_average + ", genres=" + this.genres + ", images=" + this.images + ')';
    }

    public TmdbMovieDetail(@Nullable Integer id, @Nullable String title, @Nullable String overview, @Nullable String poster_path, @Nullable String backdrop_path, @Nullable String release_date, @Nullable Double vote_average, @Nullable List<TmdbGenre> list, @Nullable TmdbImages images) {
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.poster_path = poster_path;
        this.backdrop_path = backdrop_path;
        this.release_date = release_date;
        this.vote_average = vote_average;
        this.genres = list;
        this.images = images;
    }

    public /* synthetic */ TmdbMovieDetail(Integer num, String str, String str2, String str3, String str4, String str5, Double d, List list, TmdbImages tmdbImages, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : d, (i & 128) != 0 ? null : list, (i & 256) != 0 ? null : tmdbImages);
    }

    @Nullable
    public final Integer getId() {
        return this.id;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getOverview() {
        return this.overview;
    }

    @Nullable
    public final String getPoster_path() {
        return this.poster_path;
    }

    @Nullable
    public final String getBackdrop_path() {
        return this.backdrop_path;
    }

    @Nullable
    public final String getRelease_date() {
        return this.release_date;
    }

    @Nullable
    public final Double getVote_average() {
        return this.vote_average;
    }

    @Nullable
    public final List<TmdbGenre> getGenres() {
        return this.genres;
    }

    @Nullable
    public final TmdbImages getImages() {
        return this.images;
    }
}
