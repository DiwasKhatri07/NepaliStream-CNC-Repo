package com.Kartoons;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: KartoonsParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Kartoons/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b7\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bù\u0001\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001f\u0010 J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010C\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010)J\u0010\u0010D\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010)J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010F\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010.J\u0010\u0010G\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u00101J\u0011\u0010H\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010L\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0015HÆ\u0003J\u0010\u0010M\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010)J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0080\u0002\u0010O\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00152\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010PJ\u0014\u0010Q\u001a\u00020\u00132\b\u0010R\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010S\u001a\u00020THÖ\u0081\u0004J\n\u0010U\u001a\u00020\u0003HÖ\u0081\u0004R'\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\"R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\"R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010*\u001a\u0004\b(\u0010)R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010*\u001a\u0004\b+\u0010)R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\"R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010/\u001a\u0004\b-\u0010.R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u00102\u001a\u0004\b0\u00101R\u0019\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\"R\u0019\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b:\u00104R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010*\u001a\u0004\b;\u0010)R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\"¨\u0006V"}, d2 = {"Lcom/Kartoons/LoadData;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "_id", "title", "description", "image", "coverImage", "hoverImage", "startYear", "", "endYear", "status", "rating", "", "featured", "", "tags", "", "createdAt", "Lcom/Kartoons/CreatedAt;", "updatedAt", "Lcom/Kartoons/UpdatedAt;", "slug", "seasons", "Lcom/Kartoons/Season;", "viewCount", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Boolean;Ljava/util/List;Lcom/Kartoons/CreatedAt;Lcom/Kartoons/UpdatedAt;Ljava/lang/String;Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getTitle", "getDescription", "getImage", "getCoverImage", "getHoverImage", "getStartYear", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEndYear", "getStatus", "getRating", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getFeatured", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTags", "()Ljava/util/List;", "getCreatedAt", "()Lcom/Kartoons/CreatedAt;", "getUpdatedAt", "()Lcom/Kartoons/UpdatedAt;", "getSlug", "getSeasons", "getViewCount", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Boolean;Ljava/util/List;Lcom/Kartoons/CreatedAt;Lcom/Kartoons/UpdatedAt;Ljava/lang/String;Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;)Lcom/Kartoons/LoadData;", "equals", "other", "hashCode", "", "toString", "Kartoons"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class LoadData {

    @Nullable
    private final String coverImage;

    @Nullable
    private final CreatedAt createdAt;

    @Nullable
    private final String description;

    @Nullable
    private final Long endYear;

    @Nullable
    private final Boolean featured;

    @Nullable
    private final String hoverImage;

    @JsonProperty("_id")
    @Nullable
    private final String id;

    @Nullable
    private final String image;

    @Nullable
    private final Double rating;

    @Nullable
    private final List<Season> seasons;

    @Nullable
    private final String slug;

    @Nullable
    private final Long startYear;

    @Nullable
    private final String status;

    @Nullable
    private final List<String> tags;

    @Nullable
    private final String title;

    @Nullable
    private final String type;

    @Nullable
    private final UpdatedAt updatedAt;

    @Nullable
    private final Long viewCount;

    public LoadData() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 262143, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LoadData copy$default(LoadData loadData, String str, String str2, String str3, String str4, String str5, String str6, Long l, Long l2, String str7, Double d, Boolean bool, List list, CreatedAt createdAt, UpdatedAt updatedAt, String str8, List list2, Long l3, String str9, int i, Object obj) {
        String str10;
        Long l4;
        String str11 = (i & 1) != 0 ? loadData.id : str;
        String str12 = (i & 2) != 0 ? loadData.title : str2;
        String str13 = (i & 4) != 0 ? loadData.description : str3;
        String str14 = (i & 8) != 0 ? loadData.image : str4;
        String str15 = (i & 16) != 0 ? loadData.coverImage : str5;
        String str16 = (i & 32) != 0 ? loadData.hoverImage : str6;
        Long l5 = (i & 64) != 0 ? loadData.startYear : l;
        Long l6 = (i & 128) != 0 ? loadData.endYear : l2;
        String str17 = (i & 256) != 0 ? loadData.status : str7;
        Double d2 = (i & 512) != 0 ? loadData.rating : d;
        Boolean bool2 = (i & 1024) != 0 ? loadData.featured : bool;
        List list3 = (i & 2048) != 0 ? loadData.tags : list;
        CreatedAt createdAt2 = (i & 4096) != 0 ? loadData.createdAt : createdAt;
        UpdatedAt updatedAt2 = (i & 8192) != 0 ? loadData.updatedAt : updatedAt;
        String str18 = str11;
        String str19 = (i & 16384) != 0 ? loadData.slug : str8;
        List list4 = (i & 32768) != 0 ? loadData.seasons : list2;
        Long l7 = (i & 65536) != 0 ? loadData.viewCount : l3;
        if ((i & 131072) != 0) {
            l4 = l7;
            str10 = loadData.type;
        } else {
            str10 = str9;
            l4 = l7;
        }
        return loadData.copy(str18, str12, str13, str14, str15, str16, l5, l6, str17, d2, bool2, list3, createdAt2, updatedAt2, str19, list4, l4, str10);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Double getRating() {
        return this.rating;
    }

    @Nullable
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Boolean getFeatured() {
        return this.featured;
    }

    @Nullable
    public final List<String> component12() {
        return this.tags;
    }

    @Nullable
    /* JADX INFO: renamed from: component13, reason: from getter */
    public final CreatedAt getCreatedAt() {
        return this.createdAt;
    }

    @Nullable
    /* JADX INFO: renamed from: component14, reason: from getter */
    public final UpdatedAt getUpdatedAt() {
        return this.updatedAt;
    }

    @Nullable
    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getSlug() {
        return this.slug;
    }

    @Nullable
    public final List<Season> component16() {
        return this.seasons;
    }

    @Nullable
    /* JADX INFO: renamed from: component17, reason: from getter */
    public final Long getViewCount() {
        return this.viewCount;
    }

    @Nullable
    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getImage() {
        return this.image;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getCoverImage() {
        return this.coverImage;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getHoverImage() {
        return this.hoverImage;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Long getStartYear() {
        return this.startYear;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Long getEndYear() {
        return this.endYear;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    @NotNull
    public final LoadData copy(@JsonProperty("_id") @Nullable String id, @Nullable String title, @Nullable String description, @Nullable String image, @Nullable String coverImage, @Nullable String hoverImage, @Nullable Long startYear, @Nullable Long endYear, @Nullable String status, @Nullable Double rating, @Nullable Boolean featured, @Nullable List<String> tags, @Nullable CreatedAt createdAt, @Nullable UpdatedAt updatedAt, @Nullable String slug, @Nullable List<Season> seasons, @Nullable Long viewCount, @Nullable String type) {
        return new LoadData(id, title, description, image, coverImage, hoverImage, startYear, endYear, status, rating, featured, tags, createdAt, updatedAt, slug, seasons, viewCount, type);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoadData)) {
            return false;
        }
        LoadData loadData = (LoadData) other;
        return Intrinsics.areEqual(this.id, loadData.id) && Intrinsics.areEqual(this.title, loadData.title) && Intrinsics.areEqual(this.description, loadData.description) && Intrinsics.areEqual(this.image, loadData.image) && Intrinsics.areEqual(this.coverImage, loadData.coverImage) && Intrinsics.areEqual(this.hoverImage, loadData.hoverImage) && Intrinsics.areEqual(this.startYear, loadData.startYear) && Intrinsics.areEqual(this.endYear, loadData.endYear) && Intrinsics.areEqual(this.status, loadData.status) && Intrinsics.areEqual(this.rating, loadData.rating) && Intrinsics.areEqual(this.featured, loadData.featured) && Intrinsics.areEqual(this.tags, loadData.tags) && Intrinsics.areEqual(this.createdAt, loadData.createdAt) && Intrinsics.areEqual(this.updatedAt, loadData.updatedAt) && Intrinsics.areEqual(this.slug, loadData.slug) && Intrinsics.areEqual(this.seasons, loadData.seasons) && Intrinsics.areEqual(this.viewCount, loadData.viewCount) && Intrinsics.areEqual(this.type, loadData.type);
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.description == null ? 0 : this.description.hashCode())) * 31) + (this.image == null ? 0 : this.image.hashCode())) * 31) + (this.coverImage == null ? 0 : this.coverImage.hashCode())) * 31) + (this.hoverImage == null ? 0 : this.hoverImage.hashCode())) * 31) + (this.startYear == null ? 0 : this.startYear.hashCode())) * 31) + (this.endYear == null ? 0 : this.endYear.hashCode())) * 31) + (this.status == null ? 0 : this.status.hashCode())) * 31) + (this.rating == null ? 0 : this.rating.hashCode())) * 31) + (this.featured == null ? 0 : this.featured.hashCode())) * 31) + (this.tags == null ? 0 : this.tags.hashCode())) * 31) + (this.createdAt == null ? 0 : this.createdAt.hashCode())) * 31) + (this.updatedAt == null ? 0 : this.updatedAt.hashCode())) * 31) + (this.slug == null ? 0 : this.slug.hashCode())) * 31) + (this.seasons == null ? 0 : this.seasons.hashCode())) * 31) + (this.viewCount == null ? 0 : this.viewCount.hashCode())) * 31) + (this.type != null ? this.type.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LoadData(id=").append(this.id).append(", title=").append(this.title).append(", description=").append(this.description).append(", image=").append(this.image).append(", coverImage=").append(this.coverImage).append(", hoverImage=").append(this.hoverImage).append(", startYear=").append(this.startYear).append(", endYear=").append(this.endYear).append(", status=").append(this.status).append(", rating=").append(this.rating).append(", featured=").append(this.featured).append(", tags=");
        sb.append(this.tags).append(", createdAt=").append(this.createdAt).append(", updatedAt=").append(this.updatedAt).append(", slug=").append(this.slug).append(", seasons=").append(this.seasons).append(", viewCount=").append(this.viewCount).append(", type=").append(this.type).append(')');
        return sb.toString();
    }

    public LoadData(@JsonProperty("_id") @Nullable String id, @Nullable String title, @Nullable String description, @Nullable String image, @Nullable String coverImage, @Nullable String hoverImage, @Nullable Long startYear, @Nullable Long endYear, @Nullable String status, @Nullable Double rating, @Nullable Boolean featured, @Nullable List<String> list, @Nullable CreatedAt createdAt, @Nullable UpdatedAt updatedAt, @Nullable String slug, @Nullable List<Season> list2, @Nullable Long viewCount, @Nullable String type) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.coverImage = coverImage;
        this.hoverImage = hoverImage;
        this.startYear = startYear;
        this.endYear = endYear;
        this.status = status;
        this.rating = rating;
        this.featured = featured;
        this.tags = list;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.slug = slug;
        this.seasons = list2;
        this.viewCount = viewCount;
        this.type = type;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ LoadData(String str, String str2, String str3, String str4, String str5, String str6, Long l, Long l2, String str7, Double d, Boolean bool, List list, CreatedAt createdAt, UpdatedAt updatedAt, String str8, List list2, Long l3, String str9, int i, DefaultConstructorMarker defaultConstructorMarker) {
        String str10 = (i & 1) != 0 ? null : str;
        String str11 = (i & 2) != 0 ? null : str2;
        String str12 = (i & 4) != 0 ? null : str3;
        String str13 = (i & 8) != 0 ? null : str4;
        String str14 = (i & 16) != 0 ? null : str5;
        String str15 = (i & 32) != 0 ? null : str6;
        Long l4 = (i & 64) != 0 ? null : l;
        Long l5 = (i & 128) != 0 ? null : l2;
        String str16 = (i & 256) != 0 ? null : str7;
        Double d2 = (i & 512) != 0 ? null : d;
        Boolean bool2 = (i & 1024) != 0 ? null : bool;
        List list3 = (i & 2048) != 0 ? null : list;
        CreatedAt createdAt2 = (i & 4096) != 0 ? null : createdAt;
        UpdatedAt updatedAt2 = (i & 8192) != 0 ? null : updatedAt;
        String str17 = (i & 16384) != 0 ? null : str8;
        this(str10, str11, str12, str13, str14, str15, l4, l5, str16, d2, bool2, list3, createdAt2, updatedAt2, str17, (i & 32768) != 0 ? null : list2, (i & 65536) != 0 ? null : l3, (i & 131072) != 0 ? null : str9);
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String getImage() {
        return this.image;
    }

    @Nullable
    public final String getCoverImage() {
        return this.coverImage;
    }

    @Nullable
    public final String getHoverImage() {
        return this.hoverImage;
    }

    @Nullable
    public final Long getStartYear() {
        return this.startYear;
    }

    @Nullable
    public final Long getEndYear() {
        return this.endYear;
    }

    @Nullable
    public final String getStatus() {
        return this.status;
    }

    @Nullable
    public final Double getRating() {
        return this.rating;
    }

    @Nullable
    public final Boolean getFeatured() {
        return this.featured;
    }

    @Nullable
    public final List<String> getTags() {
        return this.tags;
    }

    @Nullable
    public final CreatedAt getCreatedAt() {
        return this.createdAt;
    }

    @Nullable
    public final UpdatedAt getUpdatedAt() {
        return this.updatedAt;
    }

    @Nullable
    public final String getSlug() {
        return this.slug;
    }

    @Nullable
    public final List<Season> getSeasons() {
        return this.seasons;
    }

    @Nullable
    public final Long getViewCount() {
        return this.viewCount;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }
}
