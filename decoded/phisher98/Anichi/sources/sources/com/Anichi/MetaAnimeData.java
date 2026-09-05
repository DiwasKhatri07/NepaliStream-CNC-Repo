package com.Anichi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AnichiParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Anichi/classes.dex */
@JsonIgnoreProperties(ignoreUnknown = true)
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u008f\u0001\u0012&\b\u0003\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002\u0012\u001e\b\u0001\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012$\b\u0001\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\n\u0012\u0018\b\u0003\u0010\f\u001a\u0004\u0018\u00010\r:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u0017\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0091\u0001\u0010\u001b\u001a\u00020\u00002&\b\u0003\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u00022\u001e\b\u0003\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u00072$\b\u0003\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\n2\u0018\b\u0003\u0010\f\u001a\u0004\u0018\u00010\r:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\fHÆ\u0001J\u0014\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001f\u001a\u00020 HÖ\u0081\u0004J\n\u0010!\u001a\u00020\u0004HÖ\u0081\u0004R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001f\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016Ê\u0001\f\b#\u0012\b\b$\u0012\u0004\b\u0007\u0010\u0002¨\u0006\""}, d2 = {"Lcom/Anichi/MetaAnimeData;", "", "titles", "", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "images", "", "Lcom/Anichi/Image;", "episodes", "Lcom/Anichi/EpisodeInfo;", "mappings", "Lcom/Anichi/MetaMappings;", "<init>", "(Ljava/util/Map;Ljava/util/List;Ljava/util/Map;Lcom/Anichi/MetaMappings;)V", "getTitles", "()Ljava/util/Map;", "getImages", "()Ljava/util/List;", "getEpisodes", "getMappings", "()Lcom/Anichi/MetaMappings;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "Anichi", "Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;", "ignoreUnknown"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class MetaAnimeData {

    @Nullable
    private final Map<String, EpisodeInfo> episodes;

    @Nullable
    private final List<Image> images;

    @Nullable
    private final MetaMappings mappings;

    @Nullable
    private final Map<String, String> titles;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MetaAnimeData copy$default(MetaAnimeData metaAnimeData, Map map, List list, Map map2, MetaMappings metaMappings, int i, Object obj) {
        if ((i & 1) != 0) {
            map = metaAnimeData.titles;
        }
        if ((i & 2) != 0) {
            list = metaAnimeData.images;
        }
        if ((i & 4) != 0) {
            map2 = metaAnimeData.episodes;
        }
        if ((i & 8) != 0) {
            metaMappings = metaAnimeData.mappings;
        }
        return metaAnimeData.copy(map, list, map2, metaMappings);
    }

    @Nullable
    public final Map<String, String> component1() {
        return this.titles;
    }

    @Nullable
    public final List<Image> component2() {
        return this.images;
    }

    @Nullable
    public final Map<String, EpisodeInfo> component3() {
        return this.episodes;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final MetaMappings getMappings() {
        return this.mappings;
    }

    @NotNull
    public final MetaAnimeData copy(@JsonProperty("titles") @Nullable Map<String, String> titles, @JsonProperty("images") @Nullable List<Image> images, @JsonProperty("episodes") @Nullable Map<String, EpisodeInfo> episodes, @JsonProperty("mappings") @Nullable MetaMappings mappings) {
        return new MetaAnimeData(titles, images, episodes, mappings);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MetaAnimeData)) {
            return false;
        }
        MetaAnimeData metaAnimeData = (MetaAnimeData) other;
        return Intrinsics.areEqual(this.titles, metaAnimeData.titles) && Intrinsics.areEqual(this.images, metaAnimeData.images) && Intrinsics.areEqual(this.episodes, metaAnimeData.episodes) && Intrinsics.areEqual(this.mappings, metaAnimeData.mappings);
    }

    public int hashCode() {
        return ((((((this.titles == null ? 0 : this.titles.hashCode()) * 31) + (this.images == null ? 0 : this.images.hashCode())) * 31) + (this.episodes == null ? 0 : this.episodes.hashCode())) * 31) + (this.mappings != null ? this.mappings.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "MetaAnimeData(titles=" + this.titles + ", images=" + this.images + ", episodes=" + this.episodes + ", mappings=" + this.mappings + ')';
    }

    public MetaAnimeData(@JsonProperty("titles") @Nullable Map<String, String> map, @JsonProperty("images") @Nullable List<Image> list, @JsonProperty("episodes") @Nullable Map<String, EpisodeInfo> map2, @JsonProperty("mappings") @Nullable MetaMappings mappings) {
        this.titles = map;
        this.images = list;
        this.episodes = map2;
        this.mappings = mappings;
    }

    public /* synthetic */ MetaAnimeData(Map map, List list, Map map2, MetaMappings metaMappings, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : map, list, map2, (i & 8) != 0 ? null : metaMappings);
    }

    @Nullable
    public final Map<String, String> getTitles() {
        return this.titles;
    }

    @Nullable
    public final List<Image> getImages() {
        return this.images;
    }

    @Nullable
    public final Map<String, EpisodeInfo> getEpisodes() {
        return this.episodes;
    }

    @Nullable
    public final MetaMappings getMappings() {
        return this.mappings;
    }
}
