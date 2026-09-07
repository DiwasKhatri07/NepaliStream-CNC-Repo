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
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u001e\b\u0003\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0013Jb\u0010\u0018\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u001e\b\u0003\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000bHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0014\u0010\u001a\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004R'\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR-\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R)\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013Ê\u0001\f\b \u0012\b\b!\u0012\u0004\b\u0007\u0010\u0002¨\u0006\u001f"}, d2 = {"Lcom/AniVortex/CatalogExploreResponse;", "", "catalog", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "items", "", "Lcom/AniVortex/CatalogItem;", "hasMore", "", "has_more", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;)V", "getCatalog", "()Ljava/lang/String;", "getItems", "()Ljava/util/List;", "getHasMore", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;)Lcom/AniVortex/CatalogExploreResponse;", "equals", "other", "hashCode", "", "toString", "AniVortex", "Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;", "ignoreUnknown"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class CatalogExploreResponse {

    @JsonProperty("catalog")
    @Nullable
    private final String catalog;

    @JsonProperty("has_more")
    @Nullable
    private final Boolean hasMore;

    @JsonProperty("items")
    @Nullable
    private final List<CatalogItem> items;

    public CatalogExploreResponse() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CatalogExploreResponse copy$default(CatalogExploreResponse catalogExploreResponse, String str, List list, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = catalogExploreResponse.catalog;
        }
        if ((i & 2) != 0) {
            list = catalogExploreResponse.items;
        }
        if ((i & 4) != 0) {
            bool = catalogExploreResponse.hasMore;
        }
        return catalogExploreResponse.copy(str, list, bool);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCatalog() {
        return this.catalog;
    }

    @Nullable
    public final List<CatalogItem> component2() {
        return this.items;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Boolean getHasMore() {
        return this.hasMore;
    }

    @NotNull
    public final CatalogExploreResponse copy(@JsonProperty("catalog") @Nullable String catalog, @JsonProperty("items") @Nullable List<CatalogItem> items, @JsonProperty("has_more") @Nullable Boolean hasMore) {
        return new CatalogExploreResponse(catalog, items, hasMore);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CatalogExploreResponse)) {
            return false;
        }
        CatalogExploreResponse catalogExploreResponse = (CatalogExploreResponse) other;
        return Intrinsics.areEqual(this.catalog, catalogExploreResponse.catalog) && Intrinsics.areEqual(this.items, catalogExploreResponse.items) && Intrinsics.areEqual(this.hasMore, catalogExploreResponse.hasMore);
    }

    public int hashCode() {
        return ((((this.catalog == null ? 0 : this.catalog.hashCode()) * 31) + (this.items == null ? 0 : this.items.hashCode())) * 31) + (this.hasMore != null ? this.hasMore.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "CatalogExploreResponse(catalog=" + this.catalog + ", items=" + this.items + ", hasMore=" + this.hasMore + ')';
    }

    public CatalogExploreResponse(@JsonProperty("catalog") @Nullable String catalog, @JsonProperty("items") @Nullable List<CatalogItem> list, @JsonProperty("has_more") @Nullable Boolean hasMore) {
        this.catalog = catalog;
        this.items = list;
        this.hasMore = hasMore;
    }

    public /* synthetic */ CatalogExploreResponse(String str, List list, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : bool);
    }

    @Nullable
    public final String getCatalog() {
        return this.catalog;
    }

    @Nullable
    public final List<CatalogItem> getItems() {
        return this.items;
    }

    @Nullable
    public final Boolean getHasMore() {
        return this.hasMore;
    }
}
