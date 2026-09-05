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
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u001e\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\r\u001a\u00020\u00002\u001e\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/phisher98/EpisodeJson;", "", "items", "", "Lcom/phisher98/EpisodeItem;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "Items", "<init>", "(Ljava/util/List;)V", "getItems", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Jellyfin"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class EpisodeJson {

    @Nullable
    private final List<EpisodeItem> items;

    /* JADX WARN: Illegal instructions before constructor call */
    public EpisodeJson() {
        List list = null;
        this(list, 1, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EpisodeJson copy$default(EpisodeJson episodeJson, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = episodeJson.items;
        }
        return episodeJson.copy(list);
    }

    @Nullable
    public final List<EpisodeItem> component1() {
        return this.items;
    }

    @NotNull
    public final EpisodeJson copy(@JsonProperty("Items") @Nullable List<EpisodeItem> items) {
        return new EpisodeJson(items);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof EpisodeJson) && Intrinsics.areEqual(this.items, ((EpisodeJson) other).items);
    }

    public int hashCode() {
        if (this.items == null) {
            return 0;
        }
        return this.items.hashCode();
    }

    @NotNull
    public String toString() {
        return "EpisodeJson(items=" + this.items + ')';
    }

    public EpisodeJson(@JsonProperty("Items") @Nullable List<EpisodeItem> list) {
        this.items = list;
    }

    public /* synthetic */ EpisodeJson(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
    }

    @Nullable
    public final List<EpisodeItem> getItems() {
        return this.items;
    }
}
