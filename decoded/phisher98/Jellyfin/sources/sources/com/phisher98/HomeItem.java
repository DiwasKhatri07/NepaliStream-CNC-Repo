package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JellyfinParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Jellyfin/classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001BÃ\u0001\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0016\b\u0001\u0010\u0007\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0016\b\u0003\u0010\t\u001a\u00020\n:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b\u0012\u0018\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r\u0012\u0018\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u000f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u0012\u0018\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0012\u0012$\b\u0003\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0014:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\nHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0014HÆ\u0003JÊ\u0001\u0010*\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0016\b\u0003\u0010\u0007\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0016\b\u0003\u0010\t\u001a\u00020\n:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b2\u0018\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r2\u0018\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u000f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00102\u0018\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00122$\b\u0003\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0014:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0015HÆ\u0001¢\u0006\u0002\u0010+J\u0014\u0010,\u001a\u00020\n2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010.\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010/\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u001bR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u001f\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u00060"}, d2 = {"Lcom/phisher98/HomeItem;", "", "name", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "Name", "id", "Id", "isFolder", "", "IsFolder", "type", "Type", "productionYear", "", "ProductionYear", "premiereDate", "PremiereDate", "imageTags", "", "ImageTags", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Map;)V", "getName", "()Ljava/lang/String;", "getId", "()Z", "getType", "getProductionYear", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPremiereDate", "getImageTags", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Map;)Lcom/phisher98/HomeItem;", "equals", "other", "hashCode", "toString", "Jellyfin"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class HomeItem {

    @NotNull
    private final String id;

    @Nullable
    private final Map<String, String> imageTags;
    private final boolean isFolder;

    @NotNull
    private final String name;

    @Nullable
    private final String premiereDate;

    @Nullable
    private final Integer productionYear;

    @Nullable
    private final String type;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HomeItem copy$default(HomeItem homeItem, String str, String str2, boolean z, String str3, Integer num, String str4, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = homeItem.name;
        }
        if ((i & 2) != 0) {
            str2 = homeItem.id;
        }
        if ((i & 4) != 0) {
            z = homeItem.isFolder;
        }
        if ((i & 8) != 0) {
            str3 = homeItem.type;
        }
        if ((i & 16) != 0) {
            num = homeItem.productionYear;
        }
        if ((i & 32) != 0) {
            str4 = homeItem.premiereDate;
        }
        if ((i & 64) != 0) {
            map = homeItem.imageTags;
        }
        String str5 = str4;
        Map map2 = map;
        Integer num2 = num;
        boolean z2 = z;
        return homeItem.copy(str, str2, z2, str3, num2, str5, map2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsFolder() {
        return this.isFolder;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getProductionYear() {
        return this.productionYear;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getPremiereDate() {
        return this.premiereDate;
    }

    @Nullable
    public final Map<String, String> component7() {
        return this.imageTags;
    }

    @NotNull
    public final HomeItem copy(@JsonProperty("Name") @NotNull String name, @JsonProperty("Id") @NotNull String id, @JsonProperty("IsFolder") boolean isFolder, @JsonProperty("Type") @Nullable String type, @JsonProperty("ProductionYear") @Nullable Integer productionYear, @JsonProperty("PremiereDate") @Nullable String premiereDate, @JsonProperty("ImageTags") @Nullable Map<String, String> imageTags) {
        return new HomeItem(name, id, isFolder, type, productionYear, premiereDate, imageTags);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HomeItem)) {
            return false;
        }
        HomeItem homeItem = (HomeItem) other;
        return Intrinsics.areEqual(this.name, homeItem.name) && Intrinsics.areEqual(this.id, homeItem.id) && this.isFolder == homeItem.isFolder && Intrinsics.areEqual(this.type, homeItem.type) && Intrinsics.areEqual(this.productionYear, homeItem.productionYear) && Intrinsics.areEqual(this.premiereDate, homeItem.premiereDate) && Intrinsics.areEqual(this.imageTags, homeItem.imageTags);
    }

    public int hashCode() {
        return (((((((((((this.name.hashCode() * 31) + this.id.hashCode()) * 31) + HomeItem$$ExternalSyntheticBackport0.m1m(this.isFolder)) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.productionYear == null ? 0 : this.productionYear.hashCode())) * 31) + (this.premiereDate == null ? 0 : this.premiereDate.hashCode())) * 31) + (this.imageTags != null ? this.imageTags.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "HomeItem(name=" + this.name + ", id=" + this.id + ", isFolder=" + this.isFolder + ", type=" + this.type + ", productionYear=" + this.productionYear + ", premiereDate=" + this.premiereDate + ", imageTags=" + this.imageTags + ')';
    }

    public HomeItem(@JsonProperty("Name") @NotNull String name, @JsonProperty("Id") @NotNull String id, @JsonProperty("IsFolder") boolean isFolder, @JsonProperty("Type") @Nullable String type, @JsonProperty("ProductionYear") @Nullable Integer productionYear, @JsonProperty("PremiereDate") @Nullable String premiereDate, @JsonProperty("ImageTags") @Nullable Map<String, String> map) {
        this.name = name;
        this.id = id;
        this.isFolder = isFolder;
        this.type = type;
        this.productionYear = productionYear;
        this.premiereDate = premiereDate;
        this.imageTags = map;
    }

    public /* synthetic */ HomeItem(String str, String str2, boolean z, String str3, Integer num, String str4, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : num, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : map);
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    public final boolean isFolder() {
        return this.isFolder;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final Integer getProductionYear() {
        return this.productionYear;
    }

    @Nullable
    public final String getPremiereDate() {
        return this.premiereDate;
    }

    @Nullable
    public final Map<String, String> getImageTags() {
        return this.imageTags;
    }
}
