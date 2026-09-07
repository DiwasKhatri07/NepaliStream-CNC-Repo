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
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b#\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bñ\u0001\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b\u0012\u0018\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r\u0012\u0018\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u000f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e\u0012\u0018\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0011\u0012\u0018\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0013\u0012\u0018\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u0015:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010*\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010.\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010/\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u0010'Jø\u0001\u00102\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t2\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b2\u0018\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r2\u0018\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u000f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e2\u0018\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00112\u0018\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00132\u0018\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u0015:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0016HÆ\u0001¢\u0006\u0002\u00103J\u0014\u00104\u001a\u00020\u00152\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00106\u001a\u00020\u0003HÖ\u0081\u0004J\n\u00107\u001a\u00020\u0007HÖ\u0081\u0004R)\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR'\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR'\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR'\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR)\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b \u0010\u001aR)\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R'\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0011¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR'\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0013¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR)\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0016¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'Ê\u0001\f\b9\u0012\b\b:\u0012\u0004\b\u0007\u0010\u0002¨\u00068"}, d2 = {"Lcom/AniVortex/CatalogItem;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "title", "", "originalTitle", "original_title", "contentType", "content_type", "releaseYear", "release_year", "rating", "", "posterUrl", "poster_url", "backdropUrl", "backdrop_url", "newlyAdded", "", "newly_added", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTitle", "()Ljava/lang/String;", "getOriginalTitle", "getContentType", "getReleaseYear", "getRating", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getPosterUrl", "getBackdropUrl", "getNewlyAdded", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/AniVortex/CatalogItem;", "equals", "other", "hashCode", "toString", "AniVortex", "Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;", "ignoreUnknown"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class CatalogItem {

    @JsonProperty("backdrop_url")
    @Nullable
    private final String backdropUrl;

    @JsonProperty("content_type")
    @Nullable
    private final String contentType;

    @JsonProperty("id")
    @Nullable
    private final Integer id;

    @JsonProperty("newly_added")
    @Nullable
    private final Boolean newlyAdded;

    @JsonProperty("original_title")
    @Nullable
    private final String originalTitle;

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

    public CatalogItem() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public static /* synthetic */ CatalogItem copy$default(CatalogItem catalogItem, Integer num, String str, String str2, String str3, Integer num2, Double d, String str4, String str5, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            num = catalogItem.id;
        }
        if ((i & 2) != 0) {
            str = catalogItem.title;
        }
        if ((i & 4) != 0) {
            str2 = catalogItem.originalTitle;
        }
        if ((i & 8) != 0) {
            str3 = catalogItem.contentType;
        }
        if ((i & 16) != 0) {
            num2 = catalogItem.releaseYear;
        }
        if ((i & 32) != 0) {
            d = catalogItem.rating;
        }
        if ((i & 64) != 0) {
            str4 = catalogItem.posterUrl;
        }
        if ((i & 128) != 0) {
            str5 = catalogItem.backdropUrl;
        }
        if ((i & 256) != 0) {
            bool = catalogItem.newlyAdded;
        }
        String str6 = str5;
        Boolean bool2 = bool;
        Double d2 = d;
        String str7 = str4;
        Integer num3 = num2;
        String str8 = str2;
        return catalogItem.copy(num, str, str8, str3, num3, d2, str7, str6, bool2);
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
    public final String getOriginalTitle() {
        return this.originalTitle;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getContentType() {
        return this.contentType;
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
    public final String getPosterUrl() {
        return this.posterUrl;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getBackdropUrl() {
        return this.backdropUrl;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Boolean getNewlyAdded() {
        return this.newlyAdded;
    }

    @NotNull
    public final CatalogItem copy(@JsonProperty("id") @Nullable Integer id, @JsonProperty("title") @Nullable String title, @JsonProperty("original_title") @Nullable String originalTitle, @JsonProperty("content_type") @Nullable String contentType, @JsonProperty("release_year") @Nullable Integer releaseYear, @JsonProperty("rating") @Nullable Double rating, @JsonProperty("poster_url") @Nullable String posterUrl, @JsonProperty("backdrop_url") @Nullable String backdropUrl, @JsonProperty("newly_added") @Nullable Boolean newlyAdded) {
        return new CatalogItem(id, title, originalTitle, contentType, releaseYear, rating, posterUrl, backdropUrl, newlyAdded);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CatalogItem)) {
            return false;
        }
        CatalogItem catalogItem = (CatalogItem) other;
        return Intrinsics.areEqual(this.id, catalogItem.id) && Intrinsics.areEqual(this.title, catalogItem.title) && Intrinsics.areEqual(this.originalTitle, catalogItem.originalTitle) && Intrinsics.areEqual(this.contentType, catalogItem.contentType) && Intrinsics.areEqual(this.releaseYear, catalogItem.releaseYear) && Intrinsics.areEqual(this.rating, catalogItem.rating) && Intrinsics.areEqual(this.posterUrl, catalogItem.posterUrl) && Intrinsics.areEqual(this.backdropUrl, catalogItem.backdropUrl) && Intrinsics.areEqual(this.newlyAdded, catalogItem.newlyAdded);
    }

    public int hashCode() {
        return ((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.originalTitle == null ? 0 : this.originalTitle.hashCode())) * 31) + (this.contentType == null ? 0 : this.contentType.hashCode())) * 31) + (this.releaseYear == null ? 0 : this.releaseYear.hashCode())) * 31) + (this.rating == null ? 0 : this.rating.hashCode())) * 31) + (this.posterUrl == null ? 0 : this.posterUrl.hashCode())) * 31) + (this.backdropUrl == null ? 0 : this.backdropUrl.hashCode())) * 31) + (this.newlyAdded != null ? this.newlyAdded.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "CatalogItem(id=" + this.id + ", title=" + this.title + ", originalTitle=" + this.originalTitle + ", contentType=" + this.contentType + ", releaseYear=" + this.releaseYear + ", rating=" + this.rating + ", posterUrl=" + this.posterUrl + ", backdropUrl=" + this.backdropUrl + ", newlyAdded=" + this.newlyAdded + ')';
    }

    public CatalogItem(@JsonProperty("id") @Nullable Integer id, @JsonProperty("title") @Nullable String title, @JsonProperty("original_title") @Nullable String originalTitle, @JsonProperty("content_type") @Nullable String contentType, @JsonProperty("release_year") @Nullable Integer releaseYear, @JsonProperty("rating") @Nullable Double rating, @JsonProperty("poster_url") @Nullable String posterUrl, @JsonProperty("backdrop_url") @Nullable String backdropUrl, @JsonProperty("newly_added") @Nullable Boolean newlyAdded) {
        this.id = id;
        this.title = title;
        this.originalTitle = originalTitle;
        this.contentType = contentType;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.posterUrl = posterUrl;
        this.backdropUrl = backdropUrl;
        this.newlyAdded = newlyAdded;
    }

    public /* synthetic */ CatalogItem(Integer num, String str, String str2, String str3, Integer num2, Double d, String str4, String str5, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : num2, (i & 32) != 0 ? null : d, (i & 64) != 0 ? null : str4, (i & 128) != 0 ? null : str5, (i & 256) != 0 ? null : bool);
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
    public final String getPosterUrl() {
        return this.posterUrl;
    }

    @Nullable
    public final String getBackdropUrl() {
        return this.backdropUrl;
    }

    @Nullable
    public final Boolean getNewlyAdded() {
        return this.newlyAdded;
    }
}
