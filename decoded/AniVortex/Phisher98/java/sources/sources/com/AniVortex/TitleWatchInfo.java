package com.AniVortex;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AniVortexModels.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/AniVortex/Phisher98/java/classes.dex */
@JsonIgnoreProperties(ignoreUnknown = true)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\"\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B×\u0001\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e\u0012\u0018\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0010:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f\u0012\u0018\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0011\u0012\u0018\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010)\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010*\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0007HÆ\u0003JÞ\u0001\u0010,\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t2\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e2\u0018\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0010:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f2\u0018\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00112\u0018\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0013HÆ\u0001¢\u0006\u0002\u0010-J\u0014\u0010.\u001a\u00020\u000b2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00100\u001a\u00020\u0003HÖ\u0081\u0004J\n\u00101\u001a\u00020\u0007HÖ\u0081\u0004R)\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R'\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR'\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR)\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\n\u0010\u001cR)\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001e\u0010\u0017R)\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R'\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0011¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR'\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0013¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aÊ\u0001\f\b3\u0012\b\b4\u0012\u0004\b\u0007\u0010\u0002¨\u00062"}, d2 = {"Lcom/AniVortex/TitleWatchInfo;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "title", "", "contentType", "content_type", "isAdult", "", "is_adult", "releaseYear", "release_year", "rating", "", "overview", "posterUrl", "poster_url", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTitle", "()Ljava/lang/String;", "getContentType", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getReleaseYear", "getRating", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getOverview", "getPosterUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;)Lcom/AniVortex/TitleWatchInfo;", "equals", "other", "hashCode", "toString", "AniVortex", "Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;", "ignoreUnknown"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class TitleWatchInfo {

    @JsonProperty("content_type")
    @Nullable
    private final String contentType;

    @JsonProperty("id")
    @Nullable
    private final Integer id;

    @JsonProperty("is_adult")
    @Nullable
    private final Boolean isAdult;

    @JsonProperty("overview")
    @Nullable
    private final String overview;

    @JsonProperty("poster_url")
    @Nullable
    private final String posterUrl;

    @JsonProperty("rating")
    @Nullable
    private final Double rating;

    @JsonProperty("release_year")
    @Nullable
    private final Integer releaseYear;

    @JsonProperty("title")
    @Nullable
    private final String title;

    public TitleWatchInfo() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ TitleWatchInfo copy$default(TitleWatchInfo titleWatchInfo, Integer num, String str, String str2, Boolean bool, Integer num2, Double d, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            num = titleWatchInfo.id;
        }
        if ((i & 2) != 0) {
            str = titleWatchInfo.title;
        }
        if ((i & 4) != 0) {
            str2 = titleWatchInfo.contentType;
        }
        if ((i & 8) != 0) {
            bool = titleWatchInfo.isAdult;
        }
        if ((i & 16) != 0) {
            num2 = titleWatchInfo.releaseYear;
        }
        if ((i & 32) != 0) {
            d = titleWatchInfo.rating;
        }
        if ((i & 64) != 0) {
            str3 = titleWatchInfo.overview;
        }
        if ((i & 128) != 0) {
            str4 = titleWatchInfo.posterUrl;
        }
        String str5 = str3;
        String str6 = str4;
        Integer num3 = num2;
        Double d2 = d;
        return titleWatchInfo.copy(num, str, str2, bool, num3, d2, str5, str6);
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
    public final String getContentType() {
        return this.contentType;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Boolean getIsAdult() {
        return this.isAdult;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getReleaseYear() {
        return this.releaseYear;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Double getRating() {
        return this.rating;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getOverview() {
        return this.overview;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getPosterUrl() {
        return this.posterUrl;
    }

    @NotNull
    public final TitleWatchInfo copy(@JsonProperty("id") @Nullable Integer id, @JsonProperty("title") @Nullable String title, @JsonProperty("content_type") @Nullable String contentType, @JsonProperty("is_adult") @Nullable Boolean isAdult, @JsonProperty("release_year") @Nullable Integer releaseYear, @JsonProperty("rating") @Nullable Double rating, @JsonProperty("overview") @Nullable String overview, @JsonProperty("poster_url") @Nullable String posterUrl) {
        return new TitleWatchInfo(id, title, contentType, isAdult, releaseYear, rating, overview, posterUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TitleWatchInfo)) {
            return false;
        }
        TitleWatchInfo titleWatchInfo = (TitleWatchInfo) other;
        return Intrinsics.areEqual(this.id, titleWatchInfo.id) && Intrinsics.areEqual(this.title, titleWatchInfo.title) && Intrinsics.areEqual(this.contentType, titleWatchInfo.contentType) && Intrinsics.areEqual(this.isAdult, titleWatchInfo.isAdult) && Intrinsics.areEqual(this.releaseYear, titleWatchInfo.releaseYear) && Intrinsics.areEqual(this.rating, titleWatchInfo.rating) && Intrinsics.areEqual(this.overview, titleWatchInfo.overview) && Intrinsics.areEqual(this.posterUrl, titleWatchInfo.posterUrl);
    }

    public int hashCode() {
        return ((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.contentType == null ? 0 : this.contentType.hashCode())) * 31) + (this.isAdult == null ? 0 : this.isAdult.hashCode())) * 31) + (this.releaseYear == null ? 0 : this.releaseYear.hashCode())) * 31) + (this.rating == null ? 0 : this.rating.hashCode())) * 31) + (this.overview == null ? 0 : this.overview.hashCode())) * 31) + (this.posterUrl != null ? this.posterUrl.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "TitleWatchInfo(id=" + this.id + ", title=" + this.title + ", contentType=" + this.contentType + ", isAdult=" + this.isAdult + ", releaseYear=" + this.releaseYear + ", rating=" + this.rating + ", overview=" + this.overview + ", posterUrl=" + this.posterUrl + ')';
    }

    public TitleWatchInfo(@JsonProperty("id") @Nullable Integer id, @JsonProperty("title") @Nullable String title, @JsonProperty("content_type") @Nullable String contentType, @JsonProperty("is_adult") @Nullable Boolean isAdult, @JsonProperty("release_year") @Nullable Integer releaseYear, @JsonProperty("rating") @Nullable Double rating, @JsonProperty("overview") @Nullable String overview, @JsonProperty("poster_url") @Nullable String posterUrl) {
        this.id = id;
        this.title = title;
        this.contentType = contentType;
        this.isAdult = isAdult;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.overview = overview;
        this.posterUrl = posterUrl;
    }

    public /* synthetic */ TitleWatchInfo(Integer num, String str, String str2, Boolean bool, Integer num2, Double d, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? null : num2, (i & 32) != 0 ? null : d, (i & 64) != 0 ? null : str3, (i & 128) != 0 ? null : str4);
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
    public final String getContentType() {
        return this.contentType;
    }

    @Nullable
    public final Boolean isAdult() {
        return this.isAdult;
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
    public final String getOverview() {
        return this.overview;
    }

    @Nullable
    public final String getPosterUrl() {
        return this.posterUrl;
    }
}
