package com.MovieBlast;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: MovieBlastParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/MovieBlast/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0014\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/MovieBlast/HomeLink;", "", "url", "", "label", "active", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getUrl", "()Ljava/lang/String;", "getLabel", "getActive", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/MovieBlast/HomeLink;", "equals", "other", "hashCode", "", "toString", "MovieBlast"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class HomeLink {

    @Nullable
    private final Boolean active;

    @Nullable
    private final String label;

    @Nullable
    private final String url;

    public HomeLink() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ HomeLink copy$default(HomeLink homeLink, String str, String str2, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = homeLink.url;
        }
        if ((i & 2) != 0) {
            str2 = homeLink.label;
        }
        if ((i & 4) != 0) {
            bool = homeLink.active;
        }
        return homeLink.copy(str, str2, bool);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Boolean getActive() {
        return this.active;
    }

    @NotNull
    public final HomeLink copy(@Nullable String url, @Nullable String label, @Nullable Boolean active) {
        return new HomeLink(url, label, active);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HomeLink)) {
            return false;
        }
        HomeLink homeLink = (HomeLink) other;
        return Intrinsics.areEqual(this.url, homeLink.url) && Intrinsics.areEqual(this.label, homeLink.label) && Intrinsics.areEqual(this.active, homeLink.active);
    }

    public int hashCode() {
        return ((((this.url == null ? 0 : this.url.hashCode()) * 31) + (this.label == null ? 0 : this.label.hashCode())) * 31) + (this.active != null ? this.active.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "HomeLink(url=" + this.url + ", label=" + this.label + ", active=" + this.active + ')';
    }

    public HomeLink(@Nullable String url, @Nullable String label, @Nullable Boolean active) {
        this.url = url;
        this.label = label;
        this.active = active;
    }

    public /* synthetic */ HomeLink(String str, String str2, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : bool);
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    public final String getLabel() {
        return this.label;
    }

    @Nullable
    public final Boolean getActive() {
        return this.active;
    }
}
