package com.hindmoviez;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Hindmoviez/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0011\u0010,\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u008c\u0001\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00100J\u0014\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00104\u001a\u00020\u0003HÖ\u0081\u0004J\n\u00105\u001a\u00020\u0005HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b$\u0010\u0015¨\u00066"}, d2 = {"Lcom/hindmoviez/TmdbTvDetail;", "", "id", "", "name", "", "overview", "poster_path", "backdrop_path", "first_air_date", "vote_average", "", "genres", "", "Lcom/hindmoviez/TmdbGenre;", "images", "Lcom/hindmoviez/TmdbImages;", "number_of_seasons", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/util/List;Lcom/hindmoviez/TmdbImages;Ljava/lang/Integer;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "getOverview", "getPoster_path", "getBackdrop_path", "getFirst_air_date", "getVote_average", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getGenres", "()Ljava/util/List;", "getImages", "()Lcom/hindmoviez/TmdbImages;", "getNumber_of_seasons", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/util/List;Lcom/hindmoviez/TmdbImages;Ljava/lang/Integer;)Lcom/hindmoviez/TmdbTvDetail;", "equals", "", "other", "hashCode", "toString", "Hindmoviez"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class TmdbTvDetail {

    @Nullable
    private final String backdrop_path;

    @Nullable
    private final String first_air_date;

    @Nullable
    private final List<TmdbGenre> genres;

    @Nullable
    private final Integer id;

    @Nullable
    private final TmdbImages images;

    @Nullable
    private final String name;

    @Nullable
    private final Integer number_of_seasons;

    @Nullable
    private final String overview;

    @Nullable
    private final String poster_path;

    @Nullable
    private final Double vote_average;

    public TmdbTvDetail() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TmdbTvDetail copy$default(TmdbTvDetail tmdbTvDetail, Integer num, String str, String str2, String str3, String str4, String str5, Double d, List list, TmdbImages tmdbImages, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = tmdbTvDetail.id;
        }
        if ((i & 2) != 0) {
            str = tmdbTvDetail.name;
        }
        if ((i & 4) != 0) {
            str2 = tmdbTvDetail.overview;
        }
        if ((i & 8) != 0) {
            str3 = tmdbTvDetail.poster_path;
        }
        if ((i & 16) != 0) {
            str4 = tmdbTvDetail.backdrop_path;
        }
        if ((i & 32) != 0) {
            str5 = tmdbTvDetail.first_air_date;
        }
        if ((i & 64) != 0) {
            d = tmdbTvDetail.vote_average;
        }
        if ((i & 128) != 0) {
            list = tmdbTvDetail.genres;
        }
        if ((i & 256) != 0) {
            tmdbImages = tmdbTvDetail.images;
        }
        if ((i & 512) != 0) {
            num2 = tmdbTvDetail.number_of_seasons;
        }
        TmdbImages tmdbImages2 = tmdbImages;
        Integer num3 = num2;
        Double d2 = d;
        List list2 = list;
        String str6 = str4;
        String str7 = str5;
        return tmdbTvDetail.copy(num, str, str2, str3, str6, str7, d2, list2, tmdbImages2, num3);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Integer getNumber_of_seasons() {
        return this.number_of_seasons;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
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
    public final String getFirst_air_date() {
        return this.first_air_date;
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
    public final TmdbTvDetail copy(@Nullable Integer id, @Nullable String name, @Nullable String overview, @Nullable String poster_path, @Nullable String backdrop_path, @Nullable String first_air_date, @Nullable Double vote_average, @Nullable List<TmdbGenre> genres, @Nullable TmdbImages images, @Nullable Integer number_of_seasons) {
        return new TmdbTvDetail(id, name, overview, poster_path, backdrop_path, first_air_date, vote_average, genres, images, number_of_seasons);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TmdbTvDetail)) {
            return false;
        }
        TmdbTvDetail tmdbTvDetail = (TmdbTvDetail) other;
        return Intrinsics.areEqual(this.id, tmdbTvDetail.id) && Intrinsics.areEqual(this.name, tmdbTvDetail.name) && Intrinsics.areEqual(this.overview, tmdbTvDetail.overview) && Intrinsics.areEqual(this.poster_path, tmdbTvDetail.poster_path) && Intrinsics.areEqual(this.backdrop_path, tmdbTvDetail.backdrop_path) && Intrinsics.areEqual(this.first_air_date, tmdbTvDetail.first_air_date) && Intrinsics.areEqual(this.vote_average, tmdbTvDetail.vote_average) && Intrinsics.areEqual(this.genres, tmdbTvDetail.genres) && Intrinsics.areEqual(this.images, tmdbTvDetail.images) && Intrinsics.areEqual(this.number_of_seasons, tmdbTvDetail.number_of_seasons);
    }

    public int hashCode() {
        return ((((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.overview == null ? 0 : this.overview.hashCode())) * 31) + (this.poster_path == null ? 0 : this.poster_path.hashCode())) * 31) + (this.backdrop_path == null ? 0 : this.backdrop_path.hashCode())) * 31) + (this.first_air_date == null ? 0 : this.first_air_date.hashCode())) * 31) + (this.vote_average == null ? 0 : this.vote_average.hashCode())) * 31) + (this.genres == null ? 0 : this.genres.hashCode())) * 31) + (this.images == null ? 0 : this.images.hashCode())) * 31) + (this.number_of_seasons != null ? this.number_of_seasons.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "TmdbTvDetail(id=" + this.id + ", name=" + this.name + ", overview=" + this.overview + ", poster_path=" + this.poster_path + ", backdrop_path=" + this.backdrop_path + ", first_air_date=" + this.first_air_date + ", vote_average=" + this.vote_average + ", genres=" + this.genres + ", images=" + this.images + ", number_of_seasons=" + this.number_of_seasons + ')';
    }

    public TmdbTvDetail(@Nullable Integer id, @Nullable String name, @Nullable String overview, @Nullable String poster_path, @Nullable String backdrop_path, @Nullable String first_air_date, @Nullable Double vote_average, @Nullable List<TmdbGenre> list, @Nullable TmdbImages images, @Nullable Integer number_of_seasons) {
        this.id = id;
        this.name = name;
        this.overview = overview;
        this.poster_path = poster_path;
        this.backdrop_path = backdrop_path;
        this.first_air_date = first_air_date;
        this.vote_average = vote_average;
        this.genres = list;
        this.images = images;
        this.number_of_seasons = number_of_seasons;
    }

    public /* synthetic */ TmdbTvDetail(Integer num, String str, String str2, String str3, String str4, String str5, Double d, List list, TmdbImages tmdbImages, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : d, (i & 128) != 0 ? null : list, (i & 256) != 0 ? null : tmdbImages, (i & 512) != 0 ? null : num2);
    }

    @Nullable
    public final Integer getId() {
        return this.id;
    }

    @Nullable
    public final String getName() {
        return this.name;
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
    public final String getFirst_air_date() {
        return this.first_air_date;
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

    @Nullable
    public final Integer getNumber_of_seasons() {
        return this.number_of_seasons;
    }
}
