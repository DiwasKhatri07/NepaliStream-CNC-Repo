package com.phisher98;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003HÆ\u0003J?\u0010\u0012\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/phisher98/AnikageSource;", "", "sources", "", "Lcom/phisher98/AnikageSourceData;", "subtitles", "Lcom/phisher98/AnikageSubtitle;", "embeds", "Lcom/phisher98/AnikageEmbed;", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getSources", "()Ljava/util/List;", "getSubtitles", "getEmbeds", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class AnikageSource {

    @Nullable
    private final List<AnikageEmbed> embeds;

    @Nullable
    private final List<AnikageSourceData> sources;

    @Nullable
    private final List<AnikageSubtitle> subtitles;

    public AnikageSource() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnikageSource copy$default(AnikageSource anikageSource, List list, List list2, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            list = anikageSource.sources;
        }
        if ((i & 2) != 0) {
            list2 = anikageSource.subtitles;
        }
        if ((i & 4) != 0) {
            list3 = anikageSource.embeds;
        }
        return anikageSource.copy(list, list2, list3);
    }

    @Nullable
    public final List<AnikageSourceData> component1() {
        return this.sources;
    }

    @Nullable
    public final List<AnikageSubtitle> component2() {
        return this.subtitles;
    }

    @Nullable
    public final List<AnikageEmbed> component3() {
        return this.embeds;
    }

    @NotNull
    public final AnikageSource copy(@Nullable List<AnikageSourceData> sources, @Nullable List<AnikageSubtitle> subtitles, @Nullable List<AnikageEmbed> embeds) {
        return new AnikageSource(sources, subtitles, embeds);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnikageSource)) {
            return false;
        }
        AnikageSource anikageSource = (AnikageSource) other;
        return Intrinsics.areEqual(this.sources, anikageSource.sources) && Intrinsics.areEqual(this.subtitles, anikageSource.subtitles) && Intrinsics.areEqual(this.embeds, anikageSource.embeds);
    }

    public int hashCode() {
        return ((((this.sources == null ? 0 : this.sources.hashCode()) * 31) + (this.subtitles == null ? 0 : this.subtitles.hashCode())) * 31) + (this.embeds != null ? this.embeds.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "AnikageSource(sources=" + this.sources + ", subtitles=" + this.subtitles + ", embeds=" + this.embeds + ')';
    }

    public AnikageSource(@Nullable List<AnikageSourceData> list, @Nullable List<AnikageSubtitle> list2, @Nullable List<AnikageEmbed> list3) {
        this.sources = list;
        this.subtitles = list2;
        this.embeds = list3;
    }

    public /* synthetic */ AnikageSource(List list, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2, (i & 4) != 0 ? null : list3);
    }

    @Nullable
    public final List<AnikageSourceData> getSources() {
        return this.sources;
    }

    @Nullable
    public final List<AnikageSubtitle> getSubtitles() {
        return this.subtitles;
    }

    @Nullable
    public final List<AnikageEmbed> getEmbeds() {
        return this.embeds;
    }
}
