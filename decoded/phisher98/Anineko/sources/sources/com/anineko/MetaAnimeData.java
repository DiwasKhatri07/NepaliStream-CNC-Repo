package com.anineko;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AninekoUtils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Anineko/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u0017\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t\u0018\u00010\u0003HÆ\u0003JM\u0010\u0014\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0004HÖ\u0081\u0004R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001f\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/anineko/MetaAnimeData;", "", "titles", "", "", "images", "", "Lcom/anineko/ImageData;", "episodes", "Lcom/anineko/MetaEpisode;", "<init>", "(Ljava/util/Map;Ljava/util/List;Ljava/util/Map;)V", "getTitles", "()Ljava/util/Map;", "getImages", "()Ljava/util/List;", "getEpisodes", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Anineko"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class MetaAnimeData {

    @Nullable
    private final Map<String, MetaEpisode> episodes;

    @Nullable
    private final List<ImageData> images;

    @Nullable
    private final Map<String, String> titles;

    public MetaAnimeData() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MetaAnimeData copy$default(MetaAnimeData metaAnimeData, Map map, List list, Map map2, int i, Object obj) {
        if ((i & 1) != 0) {
            map = metaAnimeData.titles;
        }
        if ((i & 2) != 0) {
            list = metaAnimeData.images;
        }
        if ((i & 4) != 0) {
            map2 = metaAnimeData.episodes;
        }
        return metaAnimeData.copy(map, list, map2);
    }

    @Nullable
    public final Map<String, String> component1() {
        return this.titles;
    }

    @Nullable
    public final List<ImageData> component2() {
        return this.images;
    }

    @Nullable
    public final Map<String, MetaEpisode> component3() {
        return this.episodes;
    }

    @NotNull
    public final MetaAnimeData copy(@Nullable Map<String, String> titles, @Nullable List<ImageData> images, @Nullable Map<String, MetaEpisode> episodes) {
        return new MetaAnimeData(titles, images, episodes);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MetaAnimeData)) {
            return false;
        }
        MetaAnimeData metaAnimeData = (MetaAnimeData) other;
        return Intrinsics.areEqual(this.titles, metaAnimeData.titles) && Intrinsics.areEqual(this.images, metaAnimeData.images) && Intrinsics.areEqual(this.episodes, metaAnimeData.episodes);
    }

    public int hashCode() {
        return ((((this.titles == null ? 0 : this.titles.hashCode()) * 31) + (this.images == null ? 0 : this.images.hashCode())) * 31) + (this.episodes != null ? this.episodes.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "MetaAnimeData(titles=" + this.titles + ", images=" + this.images + ", episodes=" + this.episodes + ')';
    }

    public MetaAnimeData(@Nullable Map<String, String> map, @Nullable List<ImageData> list, @Nullable Map<String, MetaEpisode> map2) {
        this.titles = map;
        this.images = list;
        this.episodes = map2;
    }

    public /* synthetic */ MetaAnimeData(Map map, List list, Map map2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : map, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : map2);
    }

    @Nullable
    public final Map<String, String> getTitles() {
        return this.titles;
    }

    @Nullable
    public final List<ImageData> getImages() {
        return this.images;
    }

    @Nullable
    public final Map<String, MetaEpisode> getEpisodes() {
        return this.episodes;
    }
}
