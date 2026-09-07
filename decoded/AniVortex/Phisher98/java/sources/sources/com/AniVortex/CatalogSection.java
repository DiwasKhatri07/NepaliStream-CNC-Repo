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
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u008f\u0001\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u001e\b\u0003\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0015J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0003J\u0096\u0001\u0010\u001e\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00072\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u001e\b\u0003\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000bHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0014\u0010 \u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\"\u001a\u00020#HÖ\u0081\u0004J\n\u0010$\u001a\u00020\u0003HÖ\u0081\u0004R'\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R'\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R'\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R)\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R-\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018Ê\u0001\f\b&\u0012\b\b'\u0012\u0004\b\u0007\u0010\u0002¨\u0006%"}, d2 = {"Lcom/AniVortex/CatalogSection;", "", "key", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "title", "presentation", "hasMore", "", "has_more", "items", "", "Lcom/AniVortex/CatalogItem;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;)V", "getKey", "()Ljava/lang/String;", "getTitle", "getPresentation", "getHasMore", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getItems", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;)Lcom/AniVortex/CatalogSection;", "equals", "other", "hashCode", "", "toString", "AniVortex", "Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;", "ignoreUnknown"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class CatalogSection {

    @JsonProperty("has_more")
    @Nullable
    private final Boolean hasMore;

    @JsonProperty("items")
    @Nullable
    private final List<CatalogItem> items;

    @JsonProperty("key")
    @Nullable
    private final String key;

    @JsonProperty("presentation")
    @Nullable
    private final String presentation;

    @JsonProperty("title")
    @Nullable
    private final String title;

    public CatalogSection() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CatalogSection copy$default(CatalogSection catalogSection, String str, String str2, String str3, Boolean bool, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = catalogSection.key;
        }
        if ((i & 2) != 0) {
            str2 = catalogSection.title;
        }
        if ((i & 4) != 0) {
            str3 = catalogSection.presentation;
        }
        if ((i & 8) != 0) {
            bool = catalogSection.hasMore;
        }
        if ((i & 16) != 0) {
            list = catalogSection.items;
        }
        List list2 = list;
        String str4 = str3;
        return catalogSection.copy(str, str2, str4, bool, list2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPresentation() {
        return this.presentation;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Boolean getHasMore() {
        return this.hasMore;
    }

    @Nullable
    public final List<CatalogItem> component5() {
        return this.items;
    }

    @NotNull
    public final CatalogSection copy(@JsonProperty("key") @Nullable String key, @JsonProperty("title") @Nullable String title, @JsonProperty("presentation") @Nullable String presentation, @JsonProperty("has_more") @Nullable Boolean hasMore, @JsonProperty("items") @Nullable List<CatalogItem> items) {
        return new CatalogSection(key, title, presentation, hasMore, items);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CatalogSection)) {
            return false;
        }
        CatalogSection catalogSection = (CatalogSection) other;
        return Intrinsics.areEqual(this.key, catalogSection.key) && Intrinsics.areEqual(this.title, catalogSection.title) && Intrinsics.areEqual(this.presentation, catalogSection.presentation) && Intrinsics.areEqual(this.hasMore, catalogSection.hasMore) && Intrinsics.areEqual(this.items, catalogSection.items);
    }

    public int hashCode() {
        return ((((((((this.key == null ? 0 : this.key.hashCode()) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.presentation == null ? 0 : this.presentation.hashCode())) * 31) + (this.hasMore == null ? 0 : this.hasMore.hashCode())) * 31) + (this.items != null ? this.items.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "CatalogSection(key=" + this.key + ", title=" + this.title + ", presentation=" + this.presentation + ", hasMore=" + this.hasMore + ", items=" + this.items + ')';
    }

    public CatalogSection(@JsonProperty("key") @Nullable String key, @JsonProperty("title") @Nullable String title, @JsonProperty("presentation") @Nullable String presentation, @JsonProperty("has_more") @Nullable Boolean hasMore, @JsonProperty("items") @Nullable List<CatalogItem> list) {
        this.key = key;
        this.title = title;
        this.presentation = presentation;
        this.hasMore = hasMore;
        this.items = list;
    }

    public /* synthetic */ CatalogSection(String str, String str2, String str3, Boolean bool, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? null : list);
    }

    @Nullable
    public final String getKey() {
        return this.key;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getPresentation() {
        return this.presentation;
    }

    @Nullable
    public final Boolean getHasMore() {
        return this.hasMore;
    }

    @Nullable
    public final List<CatalogItem> getItems() {
        return this.items;
    }
}
