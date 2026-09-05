package com.Fibwatch;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Fibwatch/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/Fibwatch/LoadItem;", "", "quality", "", "url", "selected", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getQuality", "()Ljava/lang/String;", "getUrl", "getSelected", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "Fibwatch"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class LoadItem {

    @NotNull
    private final String quality;
    private final boolean selected;

    @NotNull
    private final String url;

    public static /* synthetic */ LoadItem copy$default(LoadItem loadItem, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = loadItem.quality;
        }
        if ((i & 2) != 0) {
            str2 = loadItem.url;
        }
        if ((i & 4) != 0) {
            z = loadItem.selected;
        }
        return loadItem.copy(str, str2, z);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getQuality() {
        return this.quality;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getSelected() {
        return this.selected;
    }

    @NotNull
    public final LoadItem copy(@NotNull String quality, @NotNull String url, boolean selected) {
        return new LoadItem(quality, url, selected);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoadItem)) {
            return false;
        }
        LoadItem loadItem = (LoadItem) other;
        return Intrinsics.areEqual(this.quality, loadItem.quality) && Intrinsics.areEqual(this.url, loadItem.url) && this.selected == loadItem.selected;
    }

    public int hashCode() {
        return (((this.quality.hashCode() * 31) + this.url.hashCode()) * 31) + LoadItem$$ExternalSyntheticBackport0.m1m(this.selected);
    }

    @NotNull
    public String toString() {
        return "LoadItem(quality=" + this.quality + ", url=" + this.url + ", selected=" + this.selected + ')';
    }

    public LoadItem(@NotNull String quality, @NotNull String url, boolean selected) {
        this.quality = quality;
        this.url = url;
        this.selected = selected;
    }

    public /* synthetic */ LoadItem(String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? false : z);
    }

    @NotNull
    public final String getQuality() {
        return this.quality;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public final boolean getSelected() {
        return this.selected;
    }
}
