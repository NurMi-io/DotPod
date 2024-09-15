# DotPod for Rails
In the would Rails files of Rubyfile [Opt. Gemfile] on install.
### Install Rails
To integrate Dotpod into Rails for optimizing your Ruby files, there are a few steps you can take:

1. Install the Dotpod package in your Rails app by adding this line to your Gemfile:

```ruby
gem 'dotpod'
```

Then run 'bundle install' to install the gem.

2. Configure Dotpod in your development or production environment by adding the following to your `application.rb` or `config/environments/` respectively:

```ruby
ENV\[‘DOTPOD\_OPTIONS'\] = 'optimize
