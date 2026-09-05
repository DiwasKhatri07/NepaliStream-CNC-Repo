package com.DoraBash;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DoraBashParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/DoraBash/classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u0014\u001a\u00020\bHÆ\u0003J4\u0010\u0015\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\bHÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/DoraBash/Data;", "", "episodes", "", "Lcom/DoraBash/Episode;", "max_episodes_page", "", "message", "", "<init>", "(Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;)V", "getEpisodes", "()Ljava/util/List;", "getMax_episodes_page", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMessage", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;)Lcom/DoraBash/Data;", "equals", "", "other", "hashCode", "", "toString", "DoraBash"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Data {

    @NotNull
    private final List<Episode> episodes;

    @Nullable
    private final Long max_episodes_page;

    @NotNull
    private final String message;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Data copy$default(Data data, List list, Long l, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = data.episodes;
        }
        if ((i & 2) != 0) {
            l = data.max_episodes_page;
        }
        if ((i & 4) != 0) {
            str = data.message;
        }
        return data.copy(list, l, str);
    }

    @NotNull
    public final List<Episode> component1() {
        return this.episodes;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getMax_episodes_page() {
        return this.max_episodes_page;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    @NotNull
    public final Data copy(@NotNull List<Episode> episodes, @Nullable Long max_episodes_page, @NotNull String message) {
        return new Data(episodes, max_episodes_page, message);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Data)) {
            return false;
        }
        Data data = (Data) other;
        return Intrinsics.areEqual(this.episodes, data.episodes) && Intrinsics.areEqual(this.max_episodes_page, data.max_episodes_page) && Intrinsics.areEqual(this.message, data.message);
    }

    public int hashCode() {
        return (((this.episodes.hashCode() * 31) + (this.max_episodes_page == null ? 0 : this.max_episodes_page.hashCode())) * 31) + this.message.hashCode();
    }

    @NotNull
    public String toString() {
        return "Data(episodes=" + this.episodes + ", max_episodes_page=" + this.max_episodes_page + ", message=" + this.message + ')';
    }

    public Data(@NotNull List<Episode> list, @Nullable Long max_episodes_page, @NotNull String message) {
        this.episodes = list;
        this.max_episodes_page = max_episodes_page;
        this.message = message;
    }

    public /* synthetic */ Data(List list, Long l, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? null : l, str);
    }

    @NotNull
    public final List<Episode> getEpisodes() {
        return this.episodes;
    }

    @Nullable
    public final Long getMax_episodes_page() {
        return this.max_episodes_page;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }
}
