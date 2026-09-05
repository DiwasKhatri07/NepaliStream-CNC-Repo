package com.cinefreak;

import com.lagradost.cloudstream3.ActorData;
import com.lagradost.cloudstream3.Score;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Cinefreak/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003J\u0011\u0010&\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0093\u0001\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010.\u001a\u00020/HÖ\u0081\u0004J\n\u00100\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014¨\u00061"}, d2 = {"Lcom/cinefreak/MetaLocal;", "", "name", "", "description", "actorsData", "", "Lcom/lagradost/cloudstream3/ActorData;", "year", "background", "genres", "videos", "Lcom/cinefreak/VideoLocal;", "rating", "Lcom/lagradost/cloudstream3/Score;", "logo", "imdbId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/lagradost/cloudstream3/Score;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getDescription", "getActorsData", "()Ljava/util/List;", "getYear", "getBackground", "getGenres", "getVideos", "getRating", "()Lcom/lagradost/cloudstream3/Score;", "getLogo", "getImdbId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "", "toString", "Cinefreak"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class MetaLocal {

    @Nullable
    private final List<ActorData> actorsData;

    @Nullable
    private final String background;

    @Nullable
    private final String description;

    @Nullable
    private final List<String> genres;

    @Nullable
    private final String imdbId;

    @Nullable
    private final String logo;

    @Nullable
    private final String name;

    @Nullable
    private final Score rating;

    @Nullable
    private final List<VideoLocal> videos;

    @Nullable
    private final String year;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MetaLocal copy$default(MetaLocal metaLocal, String str, String str2, List list, String str3, String str4, List list2, List list3, Score score, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = metaLocal.name;
        }
        if ((i & 2) != 0) {
            str2 = metaLocal.description;
        }
        if ((i & 4) != 0) {
            list = metaLocal.actorsData;
        }
        if ((i & 8) != 0) {
            str3 = metaLocal.year;
        }
        if ((i & 16) != 0) {
            str4 = metaLocal.background;
        }
        if ((i & 32) != 0) {
            list2 = metaLocal.genres;
        }
        if ((i & 64) != 0) {
            list3 = metaLocal.videos;
        }
        if ((i & 128) != 0) {
            score = metaLocal.rating;
        }
        if ((i & 256) != 0) {
            str5 = metaLocal.logo;
        }
        if ((i & 512) != 0) {
            str6 = metaLocal.imdbId;
        }
        String str7 = str5;
        String str8 = str6;
        List list4 = list3;
        Score score2 = score;
        String str9 = str4;
        List list5 = list2;
        return metaLocal.copy(str, str2, list, str3, str9, list5, list4, score2, str7, str8);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getImdbId() {
        return this.imdbId;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final List<ActorData> component3() {
        return this.actorsData;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getYear() {
        return this.year;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getBackground() {
        return this.background;
    }

    @Nullable
    public final List<String> component6() {
        return this.genres;
    }

    @Nullable
    public final List<VideoLocal> component7() {
        return this.videos;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Score getRating() {
        return this.rating;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getLogo() {
        return this.logo;
    }

    @NotNull
    public final MetaLocal copy(@Nullable String name, @Nullable String description, @Nullable List<ActorData> actorsData, @Nullable String year, @Nullable String background, @Nullable List<String> genres, @Nullable List<VideoLocal> videos, @Nullable Score rating, @Nullable String logo, @Nullable String imdbId) {
        return new MetaLocal(name, description, actorsData, year, background, genres, videos, rating, logo, imdbId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MetaLocal)) {
            return false;
        }
        MetaLocal metaLocal = (MetaLocal) other;
        return Intrinsics.areEqual(this.name, metaLocal.name) && Intrinsics.areEqual(this.description, metaLocal.description) && Intrinsics.areEqual(this.actorsData, metaLocal.actorsData) && Intrinsics.areEqual(this.year, metaLocal.year) && Intrinsics.areEqual(this.background, metaLocal.background) && Intrinsics.areEqual(this.genres, metaLocal.genres) && Intrinsics.areEqual(this.videos, metaLocal.videos) && Intrinsics.areEqual(this.rating, metaLocal.rating) && Intrinsics.areEqual(this.logo, metaLocal.logo) && Intrinsics.areEqual(this.imdbId, metaLocal.imdbId);
    }

    public int hashCode() {
        return ((((((((((((((((((this.name == null ? 0 : this.name.hashCode()) * 31) + (this.description == null ? 0 : this.description.hashCode())) * 31) + (this.actorsData == null ? 0 : this.actorsData.hashCode())) * 31) + (this.year == null ? 0 : this.year.hashCode())) * 31) + (this.background == null ? 0 : this.background.hashCode())) * 31) + (this.genres == null ? 0 : this.genres.hashCode())) * 31) + (this.videos == null ? 0 : this.videos.hashCode())) * 31) + (this.rating == null ? 0 : this.rating.hashCode())) * 31) + (this.logo == null ? 0 : this.logo.hashCode())) * 31) + (this.imdbId != null ? this.imdbId.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "MetaLocal(name=" + this.name + ", description=" + this.description + ", actorsData=" + this.actorsData + ", year=" + this.year + ", background=" + this.background + ", genres=" + this.genres + ", videos=" + this.videos + ", rating=" + this.rating + ", logo=" + this.logo + ", imdbId=" + this.imdbId + ')';
    }

    public MetaLocal(@Nullable String name, @Nullable String description, @Nullable List<ActorData> list, @Nullable String year, @Nullable String background, @Nullable List<String> list2, @Nullable List<VideoLocal> list3, @Nullable Score rating, @Nullable String logo, @Nullable String imdbId) {
        this.name = name;
        this.description = description;
        this.actorsData = list;
        this.year = year;
        this.background = background;
        this.genres = list2;
        this.videos = list3;
        this.rating = rating;
        this.logo = logo;
        this.imdbId = imdbId;
    }

    public /* synthetic */ MetaLocal(String str, String str2, List list, String str3, String str4, List list2, List list3, Score score, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : list2, (i & 64) != 0 ? null : list3, score, str5, str6);
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final List<ActorData> getActorsData() {
        return this.actorsData;
    }

    @Nullable
    public final String getYear() {
        return this.year;
    }

    @Nullable
    public final String getBackground() {
        return this.background;
    }

    @Nullable
    public final List<String> getGenres() {
        return this.genres;
    }

    @Nullable
    public final List<VideoLocal> getVideos() {
        return this.videos;
    }

    @Nullable
    public final Score getRating() {
        return this.rating;
    }

    @Nullable
    public final String getLogo() {
        return this.logo;
    }

    @Nullable
    public final String getImdbId() {
        return this.imdbId;
    }
}
