package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JellyfinParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Jellyfin/classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u001c\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0016\b\u0001\u0010\b\u001a\u00020\t:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\n\u0012\u0016\b\u0001\u0010\u000b\u001a\u00020\t:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\f¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\tHÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003JW\u0010\u0017\u001a\u00020\u00002\u001c\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u00072\u0016\b\u0003\u0010\b\u001a\u00020\t:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\n2\u0016\b\u0003\u0010\u000b\u001a\u00020\t:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\fHÆ\u0001J\u0014\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/phisher98/SearchResult;", "", "items", "", "Lcom/phisher98/SearchItem;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "Items", "totalRecordCount", "", "TotalRecordCount", "startIndex", "StartIndex", "<init>", "(Ljava/util/List;II)V", "getItems", "()Ljava/util/List;", "getTotalRecordCount", "()I", "getStartIndex", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "Jellyfin"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class SearchResult {

    @NotNull
    private final List<SearchItem> items;
    private final int startIndex;
    private final int totalRecordCount;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SearchResult copy$default(SearchResult searchResult, List list, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = searchResult.items;
        }
        if ((i3 & 2) != 0) {
            i = searchResult.totalRecordCount;
        }
        if ((i3 & 4) != 0) {
            i2 = searchResult.startIndex;
        }
        return searchResult.copy(list, i, i2);
    }

    @NotNull
    public final List<SearchItem> component1() {
        return this.items;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getTotalRecordCount() {
        return this.totalRecordCount;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getStartIndex() {
        return this.startIndex;
    }

    @NotNull
    public final SearchResult copy(@JsonProperty("Items") @NotNull List<SearchItem> items, @JsonProperty("TotalRecordCount") int totalRecordCount, @JsonProperty("StartIndex") int startIndex) {
        return new SearchResult(items, totalRecordCount, startIndex);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchResult)) {
            return false;
        }
        SearchResult searchResult = (SearchResult) other;
        return Intrinsics.areEqual(this.items, searchResult.items) && this.totalRecordCount == searchResult.totalRecordCount && this.startIndex == searchResult.startIndex;
    }

    public int hashCode() {
        return (((this.items.hashCode() * 31) + this.totalRecordCount) * 31) + this.startIndex;
    }

    @NotNull
    public String toString() {
        return "SearchResult(items=" + this.items + ", totalRecordCount=" + this.totalRecordCount + ", startIndex=" + this.startIndex + ')';
    }

    public SearchResult(@JsonProperty("Items") @NotNull List<SearchItem> list, @JsonProperty("TotalRecordCount") int totalRecordCount, @JsonProperty("StartIndex") int startIndex) {
        this.items = list;
        this.totalRecordCount = totalRecordCount;
        this.startIndex = startIndex;
    }

    @NotNull
    public final List<SearchItem> getItems() {
        return this.items;
    }

    public final int getTotalRecordCount() {
        return this.totalRecordCount;
    }

    public final int getStartIndex() {
        return this.startIndex;
    }
}
