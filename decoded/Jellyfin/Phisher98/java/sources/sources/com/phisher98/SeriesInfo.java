package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JellyfinParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Jellyfin/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B×\u0001\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0016\b\u0001\u0010\t\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0018\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0018\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u000e:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f\u0012\u0018\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0011:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0012\u0012\u0018\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u0014:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0015\u0012\u001c\b\u0003\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010+\u001a\u00020\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u00100\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010'J\u000f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017HÆ\u0003JÞ\u0001\u00103\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0016\b\u0003\u0010\t\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u000e:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f2\u0018\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0011:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00122\u0018\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0014:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00152\u001c\b\u0003\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0019HÆ\u0001¢\u0006\u0002\u00104J\u0014\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00108\u001a\u00020\u000eHÖ\u0081\u0004J\n\u00109\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*¨\u0006:"}, d2 = {"Lcom/phisher98/SeriesInfo;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "Id", "parentId", "ParentId", "name", "Name", "overview", "Overview", "productionYear", "", "ProductionYear", "imageTags", "Lcom/phisher98/ImageTags;", "ImageTags", "primaryImageAspectRatio", "", "PrimaryImageAspectRatio", "people", "", "Lcom/phisher98/Person;", "People", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/phisher98/ImageTags;Ljava/lang/Double;Ljava/util/List;)V", "getId", "()Ljava/lang/String;", "getParentId", "getName", "getOverview", "getProductionYear", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getImageTags", "()Lcom/phisher98/ImageTags;", "getPrimaryImageAspectRatio", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getPeople", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/phisher98/ImageTags;Ljava/lang/Double;Ljava/util/List;)Lcom/phisher98/SeriesInfo;", "equals", "", "other", "hashCode", "toString", "Jellyfin"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class SeriesInfo {

    @NotNull
    private final String id;

    @Nullable
    private final ImageTags imageTags;

    @NotNull
    private final String name;

    @Nullable
    private final String overview;

    @Nullable
    private final String parentId;

    @NotNull
    private final List<Person> people;

    @Nullable
    private final Double primaryImageAspectRatio;

    @Nullable
    private final Integer productionYear;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SeriesInfo copy$default(SeriesInfo seriesInfo, String str, String str2, String str3, String str4, Integer num, ImageTags imageTags, Double d, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = seriesInfo.id;
        }
        if ((i & 2) != 0) {
            str2 = seriesInfo.parentId;
        }
        if ((i & 4) != 0) {
            str3 = seriesInfo.name;
        }
        if ((i & 8) != 0) {
            str4 = seriesInfo.overview;
        }
        if ((i & 16) != 0) {
            num = seriesInfo.productionYear;
        }
        if ((i & 32) != 0) {
            imageTags = seriesInfo.imageTags;
        }
        if ((i & 64) != 0) {
            d = seriesInfo.primaryImageAspectRatio;
        }
        if ((i & 128) != 0) {
            list = seriesInfo.people;
        }
        Double d2 = d;
        List list2 = list;
        Integer num2 = num;
        ImageTags imageTags2 = imageTags;
        return seriesInfo.copy(str, str2, str3, str4, num2, imageTags2, d2, list2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getParentId() {
        return this.parentId;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getOverview() {
        return this.overview;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getProductionYear() {
        return this.productionYear;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final ImageTags getImageTags() {
        return this.imageTags;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Double getPrimaryImageAspectRatio() {
        return this.primaryImageAspectRatio;
    }

    @NotNull
    public final List<Person> component8() {
        return this.people;
    }

    @NotNull
    public final SeriesInfo copy(@JsonProperty("Id") @NotNull String id, @JsonProperty("ParentId") @Nullable String parentId, @JsonProperty("Name") @NotNull String name, @JsonProperty("Overview") @Nullable String overview, @JsonProperty("ProductionYear") @Nullable Integer productionYear, @JsonProperty("ImageTags") @Nullable ImageTags imageTags, @JsonProperty("PrimaryImageAspectRatio") @Nullable Double primaryImageAspectRatio, @JsonProperty("People") @NotNull List<Person> people) {
        return new SeriesInfo(id, parentId, name, overview, productionYear, imageTags, primaryImageAspectRatio, people);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SeriesInfo)) {
            return false;
        }
        SeriesInfo seriesInfo = (SeriesInfo) other;
        return Intrinsics.areEqual(this.id, seriesInfo.id) && Intrinsics.areEqual(this.parentId, seriesInfo.parentId) && Intrinsics.areEqual(this.name, seriesInfo.name) && Intrinsics.areEqual(this.overview, seriesInfo.overview) && Intrinsics.areEqual(this.productionYear, seriesInfo.productionYear) && Intrinsics.areEqual(this.imageTags, seriesInfo.imageTags) && Intrinsics.areEqual(this.primaryImageAspectRatio, seriesInfo.primaryImageAspectRatio) && Intrinsics.areEqual(this.people, seriesInfo.people);
    }

    public int hashCode() {
        return (((((((((((((this.id.hashCode() * 31) + (this.parentId == null ? 0 : this.parentId.hashCode())) * 31) + this.name.hashCode()) * 31) + (this.overview == null ? 0 : this.overview.hashCode())) * 31) + (this.productionYear == null ? 0 : this.productionYear.hashCode())) * 31) + (this.imageTags == null ? 0 : this.imageTags.hashCode())) * 31) + (this.primaryImageAspectRatio != null ? this.primaryImageAspectRatio.hashCode() : 0)) * 31) + this.people.hashCode();
    }

    @NotNull
    public String toString() {
        return "SeriesInfo(id=" + this.id + ", parentId=" + this.parentId + ", name=" + this.name + ", overview=" + this.overview + ", productionYear=" + this.productionYear + ", imageTags=" + this.imageTags + ", primaryImageAspectRatio=" + this.primaryImageAspectRatio + ", people=" + this.people + ')';
    }

    public SeriesInfo(@JsonProperty("Id") @NotNull String id, @JsonProperty("ParentId") @Nullable String parentId, @JsonProperty("Name") @NotNull String name, @JsonProperty("Overview") @Nullable String overview, @JsonProperty("ProductionYear") @Nullable Integer productionYear, @JsonProperty("ImageTags") @Nullable ImageTags imageTags, @JsonProperty("PrimaryImageAspectRatio") @Nullable Double primaryImageAspectRatio, @JsonProperty("People") @NotNull List<Person> list) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.overview = overview;
        this.productionYear = productionYear;
        this.imageTags = imageTags;
        this.primaryImageAspectRatio = primaryImageAspectRatio;
        this.people = list;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ SeriesInfo(String str, String str2, String str3, String str4, Integer num, ImageTags imageTags, Double d, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        List listEmptyList;
        if ((i & 128) == 0) {
            listEmptyList = list;
        } else {
            listEmptyList = CollectionsKt.emptyList();
        }
        this(str, str2, str3, str4, num, imageTags, d, listEmptyList);
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final String getParentId() {
        return this.parentId;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getOverview() {
        return this.overview;
    }

    @Nullable
    public final Integer getProductionYear() {
        return this.productionYear;
    }

    @Nullable
    public final ImageTags getImageTags() {
        return this.imageTags;
    }

    @Nullable
    public final Double getPrimaryImageAspectRatio() {
        return this.primaryImageAspectRatio;
    }

    @NotNull
    public final List<Person> getPeople() {
        return this.people;
    }
}
