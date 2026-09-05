package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JellyfinParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Jellyfin/classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b6\b\u0086\b\u0018\u00002\u00020\u0001B§\u0003\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0016\b\u0001\u0010\u0007\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u000e:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f\u0012\u0018\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0011\u0012\u0018\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0013:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0014\u0012\u001e\b\u0003\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0016:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0017\u0012\u0018\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u0019:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001a\u0012\u0018\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u001c:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001d\u0012\u0018\b\u0003\u0010\u001e\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001f\u0012\u0016\b\u0003\u0010 \u001a\u00020\u0019:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(!\u0012\u0018\b\u0003\u0010\"\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(#\u0012\u0018\b\u0003\u0010$\u001a\u0004\u0018\u00010%:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(&\u0012\u0018\b\u0003\u0010'\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b((\u0012\u0018\b\u0003\u0010)\u001a\u0004\u0018\u00010*:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(+¢\u0006\u0004\b,\u0010-J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010N\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u00104J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u0011\u0010Q\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0016HÆ\u0003J\u0010\u0010R\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0002\u0010<J\u0010\u0010S\u001a\u0004\u0018\u00010\u001cHÆ\u0003¢\u0006\u0002\u0010?J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010U\u001a\u00020\u0019HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010W\u001a\u0004\u0018\u00010%HÆ\u0003¢\u0006\u0002\u0010EJ\u000b\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010*HÆ\u0003J®\u0003\u0010Z\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0016\b\u0003\u0010\u0007\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u000e:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f2\u0018\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00112\u0018\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0013:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00142\u001e\b\u0003\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0016:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00172\u0018\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u0019:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001a2\u0018\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u001c:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001d2\u0018\b\u0003\u0010\u001e\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001f2\u0016\b\u0003\u0010 \u001a\u00020\u0019:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(!2\u0018\b\u0003\u0010\"\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(#2\u0018\b\u0003\u0010$\u001a\u0004\u0018\u00010%:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(&2\u0018\b\u0003\u0010'\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b((2\u0018\b\u0003\u0010)\u001a\u0004\u0018\u00010*:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(+HÆ\u0001¢\u0006\u0002\u0010[J\u0014\u0010\\\u001a\u00020\u00192\b\u0010]\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010^\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010_\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010/R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010/R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010/R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u00105\u001a\u0004\b3\u00104R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010/R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0019\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\n\n\u0002\u0010=\u001a\u0004\b;\u0010<R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\n\n\u0002\u0010@\u001a\u0004\b>\u0010?R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bA\u0010/R\u0011\u0010 \u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b \u0010BR\u0013\u0010\"\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bC\u0010/R\u0015\u0010$\u001a\u0004\u0018\u00010%¢\u0006\n\n\u0002\u0010F\u001a\u0004\bD\u0010ER\u0013\u0010'\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bG\u0010/R\u0013\u0010)\u001a\u0004\u0018\u00010*¢\u0006\b\n\u0000\u001a\u0004\bH\u0010I¨\u0006`"}, d2 = {"Lcom/phisher98/SearchItem;", "", "name", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "Name", "id", "Id", "serverId", "ServerId", "type", "Type", "productionYear", "", "ProductionYear", "premiereDate", "PremiereDate", "imageTags", "Lcom/phisher98/SearchImageTags;", "ImageTags", "backdropImageTags", "", "BackdropImageTags", "hasSubtitles", "", "HasSubtitles", "runTimeTicks", "", "RunTimeTicks", "mediaType", "MediaType", "isFolder", "IsFolder", "container", "Container", "communityRating", "", "CommunityRating", "officialRating", "OfficialRating", "userData", "Lcom/phisher98/UserData;", "UserData", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/phisher98/SearchImageTags;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Double;Ljava/lang/String;Lcom/phisher98/UserData;)V", "getName", "()Ljava/lang/String;", "getId", "getServerId", "getType", "getProductionYear", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPremiereDate", "getImageTags", "()Lcom/phisher98/SearchImageTags;", "getBackdropImageTags", "()Ljava/util/List;", "getHasSubtitles", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getRunTimeTicks", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMediaType", "()Z", "getContainer", "getCommunityRating", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getOfficialRating", "getUserData", "()Lcom/phisher98/UserData;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/phisher98/SearchImageTags;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Double;Ljava/lang/String;Lcom/phisher98/UserData;)Lcom/phisher98/SearchItem;", "equals", "other", "hashCode", "toString", "Jellyfin"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class SearchItem {

    @Nullable
    private final List<String> backdropImageTags;

    @Nullable
    private final Double communityRating;

    @Nullable
    private final String container;

    @Nullable
    private final Boolean hasSubtitles;

    @NotNull
    private final String id;

    @Nullable
    private final SearchImageTags imageTags;
    private final boolean isFolder;

    @Nullable
    private final String mediaType;

    @NotNull
    private final String name;

    @Nullable
    private final String officialRating;

    @Nullable
    private final String premiereDate;

    @Nullable
    private final Integer productionYear;

    @Nullable
    private final Long runTimeTicks;

    @Nullable
    private final String serverId;

    @Nullable
    private final String type;

    @Nullable
    private final UserData userData;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SearchItem copy$default(SearchItem searchItem, String str, String str2, String str3, String str4, Integer num, String str5, SearchImageTags searchImageTags, List list, Boolean bool, Long l, String str6, boolean z, String str7, Double d, String str8, UserData userData, int i, Object obj) {
        String str9 = (i & 1) != 0 ? searchItem.name : str;
        return searchItem.copy(str9, (i & 2) != 0 ? searchItem.id : str2, (i & 4) != 0 ? searchItem.serverId : str3, (i & 8) != 0 ? searchItem.type : str4, (i & 16) != 0 ? searchItem.productionYear : num, (i & 32) != 0 ? searchItem.premiereDate : str5, (i & 64) != 0 ? searchItem.imageTags : searchImageTags, (i & 128) != 0 ? searchItem.backdropImageTags : list, (i & 256) != 0 ? searchItem.hasSubtitles : bool, (i & 512) != 0 ? searchItem.runTimeTicks : l, (i & 1024) != 0 ? searchItem.mediaType : str6, (i & 2048) != 0 ? searchItem.isFolder : z, (i & 4096) != 0 ? searchItem.container : str7, (i & 8192) != 0 ? searchItem.communityRating : d, (i & 16384) != 0 ? searchItem.officialRating : str8, (i & 32768) != 0 ? searchItem.userData : userData);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Long getRunTimeTicks() {
        return this.runTimeTicks;
    }

    @Nullable
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getMediaType() {
        return this.mediaType;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getIsFolder() {
        return this.isFolder;
    }

    @Nullable
    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getContainer() {
        return this.container;
    }

    @Nullable
    /* JADX INFO: renamed from: component14, reason: from getter */
    public final Double getCommunityRating() {
        return this.communityRating;
    }

    @Nullable
    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getOfficialRating() {
        return this.officialRating;
    }

    @Nullable
    /* JADX INFO: renamed from: component16, reason: from getter */
    public final UserData getUserData() {
        return this.userData;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getServerId() {
        return this.serverId;
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
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final SearchImageTags getImageTags() {
        return this.imageTags;
    }

    @Nullable
    public final List<String> component8() {
        return this.backdropImageTags;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Boolean getHasSubtitles() {
        return this.hasSubtitles;
    }

    @NotNull
    public final SearchItem copy(@JsonProperty("Name") @NotNull String name, @JsonProperty("Id") @NotNull String id, @JsonProperty("ServerId") @Nullable String serverId, @JsonProperty("Type") @Nullable String type, @JsonProperty("ProductionYear") @Nullable Integer productionYear, @JsonProperty("PremiereDate") @Nullable String premiereDate, @JsonProperty("ImageTags") @Nullable SearchImageTags imageTags, @JsonProperty("BackdropImageTags") @Nullable List<String> backdropImageTags, @JsonProperty("HasSubtitles") @Nullable Boolean hasSubtitles, @JsonProperty("RunTimeTicks") @Nullable Long runTimeTicks, @JsonProperty("MediaType") @Nullable String mediaType, @JsonProperty("IsFolder") boolean isFolder, @JsonProperty("Container") @Nullable String container, @JsonProperty("CommunityRating") @Nullable Double communityRating, @JsonProperty("OfficialRating") @Nullable String officialRating, @JsonProperty("UserData") @Nullable UserData userData) {
        return new SearchItem(name, id, serverId, type, productionYear, premiereDate, imageTags, backdropImageTags, hasSubtitles, runTimeTicks, mediaType, isFolder, container, communityRating, officialRating, userData);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchItem)) {
            return false;
        }
        SearchItem searchItem = (SearchItem) other;
        return Intrinsics.areEqual(this.name, searchItem.name) && Intrinsics.areEqual(this.id, searchItem.id) && Intrinsics.areEqual(this.serverId, searchItem.serverId) && Intrinsics.areEqual(this.type, searchItem.type) && Intrinsics.areEqual(this.productionYear, searchItem.productionYear) && Intrinsics.areEqual(this.premiereDate, searchItem.premiereDate) && Intrinsics.areEqual(this.imageTags, searchItem.imageTags) && Intrinsics.areEqual(this.backdropImageTags, searchItem.backdropImageTags) && Intrinsics.areEqual(this.hasSubtitles, searchItem.hasSubtitles) && Intrinsics.areEqual(this.runTimeTicks, searchItem.runTimeTicks) && Intrinsics.areEqual(this.mediaType, searchItem.mediaType) && this.isFolder == searchItem.isFolder && Intrinsics.areEqual(this.container, searchItem.container) && Intrinsics.areEqual(this.communityRating, searchItem.communityRating) && Intrinsics.areEqual(this.officialRating, searchItem.officialRating) && Intrinsics.areEqual(this.userData, searchItem.userData);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((this.name.hashCode() * 31) + this.id.hashCode()) * 31) + (this.serverId == null ? 0 : this.serverId.hashCode())) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.productionYear == null ? 0 : this.productionYear.hashCode())) * 31) + (this.premiereDate == null ? 0 : this.premiereDate.hashCode())) * 31) + (this.imageTags == null ? 0 : this.imageTags.hashCode())) * 31) + (this.backdropImageTags == null ? 0 : this.backdropImageTags.hashCode())) * 31) + (this.hasSubtitles == null ? 0 : this.hasSubtitles.hashCode())) * 31) + (this.runTimeTicks == null ? 0 : this.runTimeTicks.hashCode())) * 31) + (this.mediaType == null ? 0 : this.mediaType.hashCode())) * 31) + SearchItem$$ExternalSyntheticBackport0.m5m(this.isFolder)) * 31) + (this.container == null ? 0 : this.container.hashCode())) * 31) + (this.communityRating == null ? 0 : this.communityRating.hashCode())) * 31) + (this.officialRating == null ? 0 : this.officialRating.hashCode())) * 31) + (this.userData != null ? this.userData.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SearchItem(name=").append(this.name).append(", id=").append(this.id).append(", serverId=").append(this.serverId).append(", type=").append(this.type).append(", productionYear=").append(this.productionYear).append(", premiereDate=").append(this.premiereDate).append(", imageTags=").append(this.imageTags).append(", backdropImageTags=").append(this.backdropImageTags).append(", hasSubtitles=").append(this.hasSubtitles).append(", runTimeTicks=").append(this.runTimeTicks).append(", mediaType=").append(this.mediaType).append(", isFolder=");
        sb.append(this.isFolder).append(", container=").append(this.container).append(", communityRating=").append(this.communityRating).append(", officialRating=").append(this.officialRating).append(", userData=").append(this.userData).append(')');
        return sb.toString();
    }

    public SearchItem(@JsonProperty("Name") @NotNull String name, @JsonProperty("Id") @NotNull String id, @JsonProperty("ServerId") @Nullable String serverId, @JsonProperty("Type") @Nullable String type, @JsonProperty("ProductionYear") @Nullable Integer productionYear, @JsonProperty("PremiereDate") @Nullable String premiereDate, @JsonProperty("ImageTags") @Nullable SearchImageTags imageTags, @JsonProperty("BackdropImageTags") @Nullable List<String> list, @JsonProperty("HasSubtitles") @Nullable Boolean hasSubtitles, @JsonProperty("RunTimeTicks") @Nullable Long runTimeTicks, @JsonProperty("MediaType") @Nullable String mediaType, @JsonProperty("IsFolder") boolean isFolder, @JsonProperty("Container") @Nullable String container, @JsonProperty("CommunityRating") @Nullable Double communityRating, @JsonProperty("OfficialRating") @Nullable String officialRating, @JsonProperty("UserData") @Nullable UserData userData) {
        this.name = name;
        this.id = id;
        this.serverId = serverId;
        this.type = type;
        this.productionYear = productionYear;
        this.premiereDate = premiereDate;
        this.imageTags = imageTags;
        this.backdropImageTags = list;
        this.hasSubtitles = hasSubtitles;
        this.runTimeTicks = runTimeTicks;
        this.mediaType = mediaType;
        this.isFolder = isFolder;
        this.container = container;
        this.communityRating = communityRating;
        this.officialRating = officialRating;
        this.userData = userData;
    }

    public /* synthetic */ SearchItem(String str, String str2, String str3, String str4, Integer num, String str5, SearchImageTags searchImageTags, List list, Boolean bool, Long l, String str6, boolean z, String str7, Double d, String str8, UserData userData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : num, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : searchImageTags, (i & 128) != 0 ? null : list, (i & 256) != 0 ? null : bool, (i & 512) != 0 ? null : l, (i & 1024) != 0 ? null : str6, (i & 2048) != 0 ? false : z, (i & 4096) != 0 ? null : str7, (i & 8192) != 0 ? null : d, (i & 16384) != 0 ? null : str8, (i & 32768) != 0 ? null : userData);
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final String getServerId() {
        return this.serverId;
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
    public final SearchImageTags getImageTags() {
        return this.imageTags;
    }

    @Nullable
    public final List<String> getBackdropImageTags() {
        return this.backdropImageTags;
    }

    @Nullable
    public final Boolean getHasSubtitles() {
        return this.hasSubtitles;
    }

    @Nullable
    public final Long getRunTimeTicks() {
        return this.runTimeTicks;
    }

    @Nullable
    public final String getMediaType() {
        return this.mediaType;
    }

    public final boolean isFolder() {
        return this.isFolder;
    }

    @Nullable
    public final String getContainer() {
        return this.container;
    }

    @Nullable
    public final Double getCommunityRating() {
        return this.communityRating;
    }

    @Nullable
    public final String getOfficialRating() {
        return this.officialRating;
    }

    @Nullable
    public final UserData getUserData() {
        return this.userData;
    }
}
