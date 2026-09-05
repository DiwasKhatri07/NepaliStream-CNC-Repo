package com.Anichi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AnichiParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Anichi/classes.dex */
@JsonIgnoreProperties(ignoreUnknown = true)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bå\u0001\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012&\b\u0003\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0018\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r\u0012\u0018\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jì\u0001\u0010%\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00072\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t2&\b\u0003\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u0018\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r2\u0018\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000eHÆ\u0001¢\u0006\u0002\u0010&J\u0014\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010*\u001a\u00020\bHÖ\u0081\u0004J\n\u0010+\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R!\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012Ê\u0001\f\b-\u0012\b\b.\u0012\u0004\b\u0007\u0010\u0002¨\u0006,"}, d2 = {"Lcom/Anichi/EpisodeInfo;", "", "episode", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "airDateUtc", "runtime", "", "image", "title", "", "overview", "rating", "finaleType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEpisode", "()Ljava/lang/String;", "getAirDateUtc", "getRuntime", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getImage", "getTitle", "()Ljava/util/Map;", "getOverview", "getRating", "getFinaleType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/Anichi/EpisodeInfo;", "equals", "", "other", "hashCode", "toString", "Anichi", "Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;", "ignoreUnknown"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class EpisodeInfo {

    @Nullable
    private final String airDateUtc;

    @Nullable
    private final String episode;

    @Nullable
    private final String finaleType;

    @Nullable
    private final String image;

    @Nullable
    private final String overview;

    @Nullable
    private final String rating;

    @Nullable
    private final Integer runtime;

    @Nullable
    private final Map<String, String> title;

    public EpisodeInfo() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EpisodeInfo copy$default(EpisodeInfo episodeInfo, String str, String str2, Integer num, String str3, Map map, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = episodeInfo.episode;
        }
        if ((i & 2) != 0) {
            str2 = episodeInfo.airDateUtc;
        }
        if ((i & 4) != 0) {
            num = episodeInfo.runtime;
        }
        if ((i & 8) != 0) {
            str3 = episodeInfo.image;
        }
        if ((i & 16) != 0) {
            map = episodeInfo.title;
        }
        if ((i & 32) != 0) {
            str4 = episodeInfo.overview;
        }
        if ((i & 64) != 0) {
            str5 = episodeInfo.rating;
        }
        if ((i & 128) != 0) {
            str6 = episodeInfo.finaleType;
        }
        String str7 = str5;
        String str8 = str6;
        Map map2 = map;
        String str9 = str4;
        return episodeInfo.copy(str, str2, num, str3, map2, str9, str7, str8);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEpisode() {
        return this.episode;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAirDateUtc() {
        return this.airDateUtc;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getRuntime() {
        return this.runtime;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getImage() {
        return this.image;
    }

    @Nullable
    public final Map<String, String> component5() {
        return this.title;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getOverview() {
        return this.overview;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getRating() {
        return this.rating;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getFinaleType() {
        return this.finaleType;
    }

    @NotNull
    public final EpisodeInfo copy(@JsonProperty("episode") @Nullable String episode, @JsonProperty("airDateUtc") @Nullable String airDateUtc, @JsonProperty("runtime") @Nullable Integer runtime, @JsonProperty("image") @Nullable String image, @JsonProperty("title") @Nullable Map<String, String> title, @JsonProperty("overview") @Nullable String overview, @JsonProperty("rating") @Nullable String rating, @JsonProperty("finaleType") @Nullable String finaleType) {
        return new EpisodeInfo(episode, airDateUtc, runtime, image, title, overview, rating, finaleType);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EpisodeInfo)) {
            return false;
        }
        EpisodeInfo episodeInfo = (EpisodeInfo) other;
        return Intrinsics.areEqual(this.episode, episodeInfo.episode) && Intrinsics.areEqual(this.airDateUtc, episodeInfo.airDateUtc) && Intrinsics.areEqual(this.runtime, episodeInfo.runtime) && Intrinsics.areEqual(this.image, episodeInfo.image) && Intrinsics.areEqual(this.title, episodeInfo.title) && Intrinsics.areEqual(this.overview, episodeInfo.overview) && Intrinsics.areEqual(this.rating, episodeInfo.rating) && Intrinsics.areEqual(this.finaleType, episodeInfo.finaleType);
    }

    public int hashCode() {
        return ((((((((((((((this.episode == null ? 0 : this.episode.hashCode()) * 31) + (this.airDateUtc == null ? 0 : this.airDateUtc.hashCode())) * 31) + (this.runtime == null ? 0 : this.runtime.hashCode())) * 31) + (this.image == null ? 0 : this.image.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.overview == null ? 0 : this.overview.hashCode())) * 31) + (this.rating == null ? 0 : this.rating.hashCode())) * 31) + (this.finaleType != null ? this.finaleType.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "EpisodeInfo(episode=" + this.episode + ", airDateUtc=" + this.airDateUtc + ", runtime=" + this.runtime + ", image=" + this.image + ", title=" + this.title + ", overview=" + this.overview + ", rating=" + this.rating + ", finaleType=" + this.finaleType + ')';
    }

    public EpisodeInfo(@JsonProperty("episode") @Nullable String episode, @JsonProperty("airDateUtc") @Nullable String airDateUtc, @JsonProperty("runtime") @Nullable Integer runtime, @JsonProperty("image") @Nullable String image, @JsonProperty("title") @Nullable Map<String, String> map, @JsonProperty("overview") @Nullable String overview, @JsonProperty("rating") @Nullable String rating, @JsonProperty("finaleType") @Nullable String finaleType) {
        this.episode = episode;
        this.airDateUtc = airDateUtc;
        this.runtime = runtime;
        this.image = image;
        this.title = map;
        this.overview = overview;
        this.rating = rating;
        this.finaleType = finaleType;
    }

    public /* synthetic */ EpisodeInfo(String str, String str2, Integer num, String str3, Map map, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : map, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : str6);
    }

    @Nullable
    public final String getEpisode() {
        return this.episode;
    }

    @Nullable
    public final String getAirDateUtc() {
        return this.airDateUtc;
    }

    @Nullable
    public final Integer getRuntime() {
        return this.runtime;
    }

    @Nullable
    public final String getImage() {
        return this.image;
    }

    @Nullable
    public final Map<String, String> getTitle() {
        return this.title;
    }

    @Nullable
    public final String getOverview() {
        return this.overview;
    }

    @Nullable
    public final String getRating() {
        return this.rating;
    }

    @Nullable
    public final String getFinaleType() {
        return this.finaleType;
    }
}
