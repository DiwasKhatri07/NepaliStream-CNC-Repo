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
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u008f\u0001\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u001e\b\u0003\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012\u0018\b\u0003\u0010\f\u001a\u0004\u0018\u00010\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0091\u0001\u0010\u001e\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u001e\b\u0003\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t2\u0018\b\u0003\u0010\f\u001a\u0004\u0018\u00010\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\fHÆ\u0001J\u0014\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\"\u001a\u00020#HÖ\u0081\u0004J\n\u0010$\u001a\u00020\u0007HÖ\u0081\u0004R'\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R'\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R'\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R-\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R'\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018Ê\u0001\f\b&\u0012\b\b'\u0012\u0004\b\u0007\u0010\u0002¨\u0006%"}, d2 = {"Lcom/AniVortex/OttTitlesResponse;", "", "platform", "Lcom/AniVortex/OttPlatform;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "catalog", "", "sort", "items", "", "Lcom/AniVortex/CatalogItem;", "page", "Lcom/AniVortex/OttPageInfo;", "<init>", "(Lcom/AniVortex/OttPlatform;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/AniVortex/OttPageInfo;)V", "getPlatform", "()Lcom/AniVortex/OttPlatform;", "getCatalog", "()Ljava/lang/String;", "getSort", "getItems", "()Ljava/util/List;", "getPage", "()Lcom/AniVortex/OttPageInfo;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "AniVortex", "Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;", "ignoreUnknown"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class OttTitlesResponse {

    @JsonProperty("catalog")
    @Nullable
    private final String catalog;

    @JsonProperty("items")
    @Nullable
    private final List<CatalogItem> items;

    @JsonProperty("page")
    @Nullable
    private final OttPageInfo page;

    @JsonProperty("platform")
    @Nullable
    private final OttPlatform platform;

    @JsonProperty("sort")
    @Nullable
    private final String sort;

    public OttTitlesResponse() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OttTitlesResponse copy$default(OttTitlesResponse ottTitlesResponse, OttPlatform ottPlatform, String str, String str2, List list, OttPageInfo ottPageInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            ottPlatform = ottTitlesResponse.platform;
        }
        if ((i & 2) != 0) {
            str = ottTitlesResponse.catalog;
        }
        if ((i & 4) != 0) {
            str2 = ottTitlesResponse.sort;
        }
        if ((i & 8) != 0) {
            list = ottTitlesResponse.items;
        }
        if ((i & 16) != 0) {
            ottPageInfo = ottTitlesResponse.page;
        }
        OttPageInfo ottPageInfo2 = ottPageInfo;
        String str3 = str2;
        return ottTitlesResponse.copy(ottPlatform, str, str3, list, ottPageInfo2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final OttPlatform getPlatform() {
        return this.platform;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCatalog() {
        return this.catalog;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSort() {
        return this.sort;
    }

    @Nullable
    public final List<CatalogItem> component4() {
        return this.items;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final OttPageInfo getPage() {
        return this.page;
    }

    @NotNull
    public final OttTitlesResponse copy(@JsonProperty("platform") @Nullable OttPlatform platform, @JsonProperty("catalog") @Nullable String catalog, @JsonProperty("sort") @Nullable String sort, @JsonProperty("items") @Nullable List<CatalogItem> items, @JsonProperty("page") @Nullable OttPageInfo page) {
        return new OttTitlesResponse(platform, catalog, sort, items, page);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OttTitlesResponse)) {
            return false;
        }
        OttTitlesResponse ottTitlesResponse = (OttTitlesResponse) other;
        return Intrinsics.areEqual(this.platform, ottTitlesResponse.platform) && Intrinsics.areEqual(this.catalog, ottTitlesResponse.catalog) && Intrinsics.areEqual(this.sort, ottTitlesResponse.sort) && Intrinsics.areEqual(this.items, ottTitlesResponse.items) && Intrinsics.areEqual(this.page, ottTitlesResponse.page);
    }

    public int hashCode() {
        return ((((((((this.platform == null ? 0 : this.platform.hashCode()) * 31) + (this.catalog == null ? 0 : this.catalog.hashCode())) * 31) + (this.sort == null ? 0 : this.sort.hashCode())) * 31) + (this.items == null ? 0 : this.items.hashCode())) * 31) + (this.page != null ? this.page.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "OttTitlesResponse(platform=" + this.platform + ", catalog=" + this.catalog + ", sort=" + this.sort + ", items=" + this.items + ", page=" + this.page + ')';
    }

    public OttTitlesResponse(@JsonProperty("platform") @Nullable OttPlatform platform, @JsonProperty("catalog") @Nullable String catalog, @JsonProperty("sort") @Nullable String sort, @JsonProperty("items") @Nullable List<CatalogItem> list, @JsonProperty("page") @Nullable OttPageInfo page) {
        this.platform = platform;
        this.catalog = catalog;
        this.sort = sort;
        this.items = list;
        this.page = page;
    }

    public /* synthetic */ OttTitlesResponse(OttPlatform ottPlatform, String str, String str2, List list, OttPageInfo ottPageInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : ottPlatform, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : list, (i & 16) != 0 ? null : ottPageInfo);
    }

    @Nullable
    public final OttPlatform getPlatform() {
        return this.platform;
    }

    @Nullable
    public final String getCatalog() {
        return this.catalog;
    }

    @Nullable
    public final String getSort() {
        return this.sort;
    }

    @Nullable
    public final List<CatalogItem> getItems() {
        return this.items;
    }

    @Nullable
    public final OttPageInfo getPage() {
        return this.page;
    }
}
