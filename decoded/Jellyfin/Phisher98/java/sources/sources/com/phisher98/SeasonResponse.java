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
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u001c\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J'\u0010\r\u001a\u00020\u00002\u001c\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/phisher98/SeasonResponse;", "", "items", "", "Lcom/phisher98/SeasonItem;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "Items", "<init>", "(Ljava/util/List;)V", "getItems", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Jellyfin"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class SeasonResponse {

    @NotNull
    private final List<SeasonItem> items;

    /* JADX WARN: Illegal instructions before constructor call */
    public SeasonResponse() {
        List list = null;
        this(list, 1, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SeasonResponse copy$default(SeasonResponse seasonResponse, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = seasonResponse.items;
        }
        return seasonResponse.copy(list);
    }

    @NotNull
    public final List<SeasonItem> component1() {
        return this.items;
    }

    @NotNull
    public final SeasonResponse copy(@JsonProperty("Items") @NotNull List<SeasonItem> items) {
        return new SeasonResponse(items);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SeasonResponse) && Intrinsics.areEqual(this.items, ((SeasonResponse) other).items);
    }

    public int hashCode() {
        return this.items.hashCode();
    }

    @NotNull
    public String toString() {
        return "SeasonResponse(items=" + this.items + ')';
    }

    public SeasonResponse(@JsonProperty("Items") @NotNull List<SeasonItem> list) {
        this.items = list;
    }

    public /* synthetic */ SeasonResponse(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
    }

    @NotNull
    public final List<SeasonItem> getItems() {
        return this.items;
    }
}
