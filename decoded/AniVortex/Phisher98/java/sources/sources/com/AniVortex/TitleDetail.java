package com.AniVortex;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AniVortexModels.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/AniVortex/Phisher98/java/classes.dex */
@JsonIgnoreProperties(ignoreUnknown = true)
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b4\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bó\u0003\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b\u0012\u0018\b\u0003\u0010\f\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r\u0012\u0018\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f\u0012\u0018\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0011\u0012\u0018\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0013:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0012\u0012\u0018\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0015\u0012\u0018\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0016\u0012\u0018\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0018\u0012\u0018\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001a\u0012\u0018\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001b\u0012\u001e\b\u0003\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001d:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001c\u0012\u001e\b\u0003\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001d:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001e\u0012\u001e\b\u0003\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001d:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001f\u0012\u0018\b\u0003\u0010!\u001a\u0004\u0018\u00010\":\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(#\u0012\u001e\b\u0003\u0010$\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\u001d:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b($¢\u0006\u0004\b&\u0010'J\u0010\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010)J\u0010\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010)J\u000b\u0010C\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010)J\u0010\u0010H\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u00103J\u000b\u0010I\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u0010N\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001dHÆ\u0003J\u0011\u0010O\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001dHÆ\u0003J\u0011\u0010P\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001dHÆ\u0003J\u0010\u0010Q\u001a\u0004\u0018\u00010\"HÆ\u0003¢\u0006\u0002\u0010>J\u0011\u0010R\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\u001dHÆ\u0003Jú\u0003\u0010S\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00072\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b2\u0018\b\u0003\u0010\f\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r2\u0018\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f2\u0018\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00112\u0018\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0013:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00122\u0018\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00152\u0018\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00162\u0018\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00182\u0018\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001a2\u0018\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001b2\u001e\b\u0003\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001d:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001c2\u001e\b\u0003\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001d:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001e2\u001e\b\u0003\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001d:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001f2\u0018\b\u0003\u0010!\u001a\u0004\u0018\u00010\":\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(#2\u001e\b\u0003\u0010$\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\u001d:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b($HÆ\u0001¢\u0006\u0002\u0010TJ\u0014\u0010U\u001a\u00020\"2\b\u0010V\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010W\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010X\u001a\u00020\tHÖ\u0081\u0004R)\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\n\n\u0002\u0010*\u001a\u0004\b(\u0010)R)\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007¢\u0006\n\n\u0002\u0010*\u001a\u0004\b+\u0010)R'\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R'\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b¢\u0006\b\n\u0000\u001a\u0004\b.\u0010-R'\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r¢\u0006\b\n\u0000\u001a\u0004\b/\u0010-R'\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f¢\u0006\b\n\u0000\u001a\u0004\b0\u0010-R)\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0011¢\u0006\n\n\u0002\u0010*\u001a\u0004\b1\u0010)R)\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0012¢\u0006\n\n\u0002\u00104\u001a\u0004\b2\u00103R'\u0010\u0014\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0015¢\u0006\b\n\u0000\u001a\u0004\b5\u0010-R'\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0016¢\u0006\b\n\u0000\u001a\u0004\b6\u0010-R'\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0018¢\u0006\b\n\u0000\u001a\u0004\b7\u0010-R'\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001a¢\u0006\b\n\u0000\u001a\u0004\b8\u0010-R'\u0010\u001b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001b¢\u0006\b\n\u0000\u001a\u0004\b9\u0010-R-\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001d8\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001c¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R-\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001d8\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001e¢\u0006\b\n\u0000\u001a\u0004\b<\u0010;R-\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001d8\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001f¢\u0006\b\n\u0000\u001a\u0004\b=\u0010;R)\u0010!\u001a\u0004\u0018\u00010\"8\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(#¢\u0006\n\n\u0002\u0010?\u001a\u0004\b!\u0010>R-\u0010$\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\u001d8\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b($¢\u0006\b\n\u0000\u001a\u0004\b@\u0010;Ê\u0001\f\bZ\u0012\b\b[\u0012\u0004\b\u0007\u0010\u0002¨\u0006Y"}, d2 = {"Lcom/AniVortex/TitleDetail;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "tmdbId", "tmdb_id", "imdbId", "", "imdb_id", "title", "originalTitle", "original_title", "contentType", "content_type", "releaseYear", "release_year", "rating", "", "votesLabel", "votes_label", "overview", "posterUrl", "poster_url", "backdropUrl", "backdrop_url", "country", "genres", "", "languages", "cast", "Lcom/AniVortex/CastMember;", "isAdult", "", "is_adult", "recommendations", "Lcom/AniVortex/CatalogItem;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/util/List;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTmdbId", "getImdbId", "()Ljava/lang/String;", "getTitle", "getOriginalTitle", "getContentType", "getReleaseYear", "getRating", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getVotesLabel", "getOverview", "getPosterUrl", "getBackdropUrl", "getCountry", "getGenres", "()Ljava/util/List;", "getLanguages", "getCast", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getRecommendations", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/util/List;)Lcom/AniVortex/TitleDetail;", "equals", "other", "hashCode", "toString", "AniVortex", "Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;", "ignoreUnknown"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class TitleDetail {

    @JsonProperty("backdrop_url")
    @Nullable
    private final String backdropUrl;

    @JsonProperty("cast")
    @Nullable
    private final List<CastMember> cast;

    @JsonProperty("content_type")
    @Nullable
    private final String contentType;

    @JsonProperty("country")
    @Nullable
    private final String country;

    @JsonProperty("genres")
    @Nullable
    private final List<String> genres;

    @JsonProperty("id")
    @Nullable
    private final Integer id;

    @JsonProperty("imdb_id")
    @Nullable
    private final String imdbId;

    @JsonProperty("is_adult")
    @Nullable
    private final Boolean isAdult;

    @JsonProperty("languages")
    @Nullable
    private final List<String> languages;

    @JsonProperty("original_title")
    @Nullable
    private final String originalTitle;

    @JsonProperty("overview")
    @Nullable
    private final String overview;

    @JsonProperty("poster_url")
    @Nullable
    private final String posterUrl;

    @JsonProperty("rating")
    @Nullable
    private final Double rating;

    @JsonProperty("recommendations")
    @Nullable
    private final List<CatalogItem> recommendations;

    @JsonProperty("release_year")
    @Nullable
    private final Integer releaseYear;

    @JsonProperty("title")
    @Nullable
    private final String title;

    @JsonProperty("tmdb_id")
    @Nullable
    private final Integer tmdbId;

    @JsonProperty("votes_label")
    @Nullable
    private final String votesLabel;

    public TitleDetail() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 262143, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TitleDetail copy$default(TitleDetail titleDetail, Integer num, Integer num2, String str, String str2, String str3, String str4, Integer num3, Double d, String str5, String str6, String str7, String str8, String str9, List list, List list2, List list3, Boolean bool, List list4, int i, Object obj) {
        List list5;
        Boolean bool2;
        Integer num4 = (i & 1) != 0 ? titleDetail.id : num;
        Integer num5 = (i & 2) != 0 ? titleDetail.tmdbId : num2;
        String str10 = (i & 4) != 0 ? titleDetail.imdbId : str;
        String str11 = (i & 8) != 0 ? titleDetail.title : str2;
        String str12 = (i & 16) != 0 ? titleDetail.originalTitle : str3;
        String str13 = (i & 32) != 0 ? titleDetail.contentType : str4;
        Integer num6 = (i & 64) != 0 ? titleDetail.releaseYear : num3;
        Double d2 = (i & 128) != 0 ? titleDetail.rating : d;
        String str14 = (i & 256) != 0 ? titleDetail.votesLabel : str5;
        String str15 = (i & 512) != 0 ? titleDetail.overview : str6;
        String str16 = (i & 1024) != 0 ? titleDetail.posterUrl : str7;
        String str17 = (i & 2048) != 0 ? titleDetail.backdropUrl : str8;
        String str18 = (i & 4096) != 0 ? titleDetail.country : str9;
        List list6 = (i & 8192) != 0 ? titleDetail.genres : list;
        Integer num7 = num4;
        List list7 = (i & 16384) != 0 ? titleDetail.languages : list2;
        List list8 = (i & 32768) != 0 ? titleDetail.cast : list3;
        Boolean bool3 = (i & 65536) != 0 ? titleDetail.isAdult : bool;
        if ((i & 131072) != 0) {
            bool2 = bool3;
            list5 = titleDetail.recommendations;
        } else {
            list5 = list4;
            bool2 = bool3;
        }
        return titleDetail.copy(num7, num5, str10, str11, str12, str13, num6, d2, str14, str15, str16, str17, str18, list6, list7, list8, bool2, list5);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getOverview() {
        return this.overview;
    }

    @Nullable
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getPosterUrl() {
        return this.posterUrl;
    }

    @Nullable
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getBackdropUrl() {
        return this.backdropUrl;
    }

    @Nullable
    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getCountry() {
        return this.country;
    }

    @Nullable
    public final List<String> component14() {
        return this.genres;
    }

    @Nullable
    public final List<String> component15() {
        return this.languages;
    }

    @Nullable
    public final List<CastMember> component16() {
        return this.cast;
    }

    @Nullable
    /* JADX INFO: renamed from: component17, reason: from getter */
    public final Boolean getIsAdult() {
        return this.isAdult;
    }

    @Nullable
    public final List<CatalogItem> component18() {
        return this.recommendations;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getTmdbId() {
        return this.tmdbId;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getImdbId() {
        return this.imdbId;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getOriginalTitle() {
        return this.originalTitle;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getContentType() {
        return this.contentType;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Integer getReleaseYear() {
        return this.releaseYear;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Double getRating() {
        return this.rating;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getVotesLabel() {
        return this.votesLabel;
    }

    @NotNull
    public final TitleDetail copy(@JsonProperty("id") @Nullable Integer id, @JsonProperty("tmdb_id") @Nullable Integer tmdbId, @JsonProperty("imdb_id") @Nullable String imdbId, @JsonProperty("title") @Nullable String title, @JsonProperty("original_title") @Nullable String originalTitle, @JsonProperty("content_type") @Nullable String contentType, @JsonProperty("release_year") @Nullable Integer releaseYear, @JsonProperty("rating") @Nullable Double rating, @JsonProperty("votes_label") @Nullable String votesLabel, @JsonProperty("overview") @Nullable String overview, @JsonProperty("poster_url") @Nullable String posterUrl, @JsonProperty("backdrop_url") @Nullable String backdropUrl, @JsonProperty("country") @Nullable String country, @JsonProperty("genres") @Nullable List<String> genres, @JsonProperty("languages") @Nullable List<String> languages, @JsonProperty("cast") @Nullable List<CastMember> cast, @JsonProperty("is_adult") @Nullable Boolean isAdult, @JsonProperty("recommendations") @Nullable List<CatalogItem> recommendations) {
        return new TitleDetail(id, tmdbId, imdbId, title, originalTitle, contentType, releaseYear, rating, votesLabel, overview, posterUrl, backdropUrl, country, genres, languages, cast, isAdult, recommendations);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TitleDetail)) {
            return false;
        }
        TitleDetail titleDetail = (TitleDetail) other;
        return Intrinsics.areEqual(this.id, titleDetail.id) && Intrinsics.areEqual(this.tmdbId, titleDetail.tmdbId) && Intrinsics.areEqual(this.imdbId, titleDetail.imdbId) && Intrinsics.areEqual(this.title, titleDetail.title) && Intrinsics.areEqual(this.originalTitle, titleDetail.originalTitle) && Intrinsics.areEqual(this.contentType, titleDetail.contentType) && Intrinsics.areEqual(this.releaseYear, titleDetail.releaseYear) && Intrinsics.areEqual(this.rating, titleDetail.rating) && Intrinsics.areEqual(this.votesLabel, titleDetail.votesLabel) && Intrinsics.areEqual(this.overview, titleDetail.overview) && Intrinsics.areEqual(this.posterUrl, titleDetail.posterUrl) && Intrinsics.areEqual(this.backdropUrl, titleDetail.backdropUrl) && Intrinsics.areEqual(this.country, titleDetail.country) && Intrinsics.areEqual(this.genres, titleDetail.genres) && Intrinsics.areEqual(this.languages, titleDetail.languages) && Intrinsics.areEqual(this.cast, titleDetail.cast) && Intrinsics.areEqual(this.isAdult, titleDetail.isAdult) && Intrinsics.areEqual(this.recommendations, titleDetail.recommendations);
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.tmdbId == null ? 0 : this.tmdbId.hashCode())) * 31) + (this.imdbId == null ? 0 : this.imdbId.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.originalTitle == null ? 0 : this.originalTitle.hashCode())) * 31) + (this.contentType == null ? 0 : this.contentType.hashCode())) * 31) + (this.releaseYear == null ? 0 : this.releaseYear.hashCode())) * 31) + (this.rating == null ? 0 : this.rating.hashCode())) * 31) + (this.votesLabel == null ? 0 : this.votesLabel.hashCode())) * 31) + (this.overview == null ? 0 : this.overview.hashCode())) * 31) + (this.posterUrl == null ? 0 : this.posterUrl.hashCode())) * 31) + (this.backdropUrl == null ? 0 : this.backdropUrl.hashCode())) * 31) + (this.country == null ? 0 : this.country.hashCode())) * 31) + (this.genres == null ? 0 : this.genres.hashCode())) * 31) + (this.languages == null ? 0 : this.languages.hashCode())) * 31) + (this.cast == null ? 0 : this.cast.hashCode())) * 31) + (this.isAdult == null ? 0 : this.isAdult.hashCode())) * 31) + (this.recommendations != null ? this.recommendations.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TitleDetail(id=").append(this.id).append(", tmdbId=").append(this.tmdbId).append(", imdbId=").append(this.imdbId).append(", title=").append(this.title).append(", originalTitle=").append(this.originalTitle).append(", contentType=").append(this.contentType).append(", releaseYear=").append(this.releaseYear).append(", rating=").append(this.rating).append(", votesLabel=").append(this.votesLabel).append(", overview=").append(this.overview).append(", posterUrl=").append(this.posterUrl).append(", backdropUrl=");
        sb.append(this.backdropUrl).append(", country=").append(this.country).append(", genres=").append(this.genres).append(", languages=").append(this.languages).append(", cast=").append(this.cast).append(", isAdult=").append(this.isAdult).append(", recommendations=").append(this.recommendations).append(')');
        return sb.toString();
    }

    public TitleDetail(@JsonProperty("id") @Nullable Integer id, @JsonProperty("tmdb_id") @Nullable Integer tmdbId, @JsonProperty("imdb_id") @Nullable String imdbId, @JsonProperty("title") @Nullable String title, @JsonProperty("original_title") @Nullable String originalTitle, @JsonProperty("content_type") @Nullable String contentType, @JsonProperty("release_year") @Nullable Integer releaseYear, @JsonProperty("rating") @Nullable Double rating, @JsonProperty("votes_label") @Nullable String votesLabel, @JsonProperty("overview") @Nullable String overview, @JsonProperty("poster_url") @Nullable String posterUrl, @JsonProperty("backdrop_url") @Nullable String backdropUrl, @JsonProperty("country") @Nullable String country, @JsonProperty("genres") @Nullable List<String> list, @JsonProperty("languages") @Nullable List<String> list2, @JsonProperty("cast") @Nullable List<CastMember> list3, @JsonProperty("is_adult") @Nullable Boolean isAdult, @JsonProperty("recommendations") @Nullable List<CatalogItem> list4) {
        this.id = id;
        this.tmdbId = tmdbId;
        this.imdbId = imdbId;
        this.title = title;
        this.originalTitle = originalTitle;
        this.contentType = contentType;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.votesLabel = votesLabel;
        this.overview = overview;
        this.posterUrl = posterUrl;
        this.backdropUrl = backdropUrl;
        this.country = country;
        this.genres = list;
        this.languages = list2;
        this.cast = list3;
        this.isAdult = isAdult;
        this.recommendations = list4;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ TitleDetail(Integer num, Integer num2, String str, String str2, String str3, String str4, Integer num3, Double d, String str5, String str6, String str7, String str8, String str9, List list, List list2, List list3, Boolean bool, List list4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Integer num4 = (i & 1) != 0 ? null : num;
        Integer num5 = (i & 2) != 0 ? null : num2;
        String str10 = (i & 4) != 0 ? null : str;
        String str11 = (i & 8) != 0 ? null : str2;
        String str12 = (i & 16) != 0 ? null : str3;
        String str13 = (i & 32) != 0 ? null : str4;
        Integer num6 = (i & 64) != 0 ? null : num3;
        Double d2 = (i & 128) != 0 ? null : d;
        String str14 = (i & 256) != 0 ? null : str5;
        String str15 = (i & 512) != 0 ? null : str6;
        String str16 = (i & 1024) != 0 ? null : str7;
        String str17 = (i & 2048) != 0 ? null : str8;
        String str18 = (i & 4096) != 0 ? null : str9;
        List list5 = (i & 8192) != 0 ? null : list;
        List list6 = (i & 16384) != 0 ? null : list2;
        this(num4, num5, str10, str11, str12, str13, num6, d2, str14, str15, str16, str17, str18, list5, list6, (i & 32768) != 0 ? null : list3, (i & 65536) != 0 ? null : bool, (i & 131072) != 0 ? null : list4);
    }

    @Nullable
    public final Integer getId() {
        return this.id;
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
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getOriginalTitle() {
        return this.originalTitle;
    }

    @Nullable
    public final String getContentType() {
        return this.contentType;
    }

    @Nullable
    public final Integer getReleaseYear() {
        return this.releaseYear;
    }

    @Nullable
    public final Double getRating() {
        return this.rating;
    }

    @Nullable
    public final String getVotesLabel() {
        return this.votesLabel;
    }

    @Nullable
    public final String getOverview() {
        return this.overview;
    }

    @Nullable
    public final String getPosterUrl() {
        return this.posterUrl;
    }

    @Nullable
    public final String getBackdropUrl() {
        return this.backdropUrl;
    }

    @Nullable
    public final String getCountry() {
        return this.country;
    }

    @Nullable
    public final List<String> getGenres() {
        return this.genres;
    }

    @Nullable
    public final List<String> getLanguages() {
        return this.languages;
    }

    @Nullable
    public final List<CastMember> getCast() {
        return this.cast;
    }

    @Nullable
    public final Boolean isAdult() {
        return this.isAdult;
    }

    @Nullable
    public final List<CatalogItem> getRecommendations() {
        return this.recommendations;
    }
}
