package com.Fibwatch;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Fibwatch/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/Fibwatch/Popup;", "", "res", "", "url", "selected", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getRes", "()Ljava/lang/String;", "getUrl", "getSelected", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "Fibwatch"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Popup {

    @Nullable
    private final String res;
    private final boolean selected;

    @Nullable
    private final String url;

    public static /* synthetic */ Popup copy$default(Popup popup, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = popup.res;
        }
        if ((i & 2) != 0) {
            str2 = popup.url;
        }
        if ((i & 4) != 0) {
            z = popup.selected;
        }
        return popup.copy(str, str2, z);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getRes() {
        return this.res;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getSelected() {
        return this.selected;
    }

    @NotNull
    public final Popup copy(@Nullable String res, @Nullable String url, boolean selected) {
        return new Popup(res, url, selected);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Popup)) {
            return false;
        }
        Popup popup = (Popup) other;
        return Intrinsics.areEqual(this.res, popup.res) && Intrinsics.areEqual(this.url, popup.url) && this.selected == popup.selected;
    }

    public int hashCode() {
        return ((((this.res == null ? 0 : this.res.hashCode()) * 31) + (this.url != null ? this.url.hashCode() : 0)) * 31) + Popup$$ExternalSyntheticBackport0.m2m(this.selected);
    }

    @NotNull
    public String toString() {
        return "Popup(res=" + this.res + ", url=" + this.url + ", selected=" + this.selected + ')';
    }

    public Popup(@Nullable String res, @Nullable String url, boolean selected) {
        this.res = res;
        this.url = url;
        this.selected = selected;
    }

    public /* synthetic */ Popup(String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? false : z);
    }

    @Nullable
    public final String getRes() {
        return this.res;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    public final boolean getSelected() {
        return this.selected;
    }
}
